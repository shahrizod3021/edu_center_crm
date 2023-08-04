package edu.center.edu_center.Service;

import edu.center.edu_center.Entity.*;
import edu.center.edu_center.Entity.Enums.DoOrNotName;
import edu.center.edu_center.Exeptions.BadRequestExeption;
import edu.center.edu_center.Full.UserFull.PupilFullCrud;
import edu.center.edu_center.Repository.*;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqPupil;
import edu.center.edu_center.payload.ResPagable;
import edu.center.edu_center.payload.ResPupil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PupilService implements PupilFullCrud {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final CourseRepo courseRepo;

    private final LidStatusRepo lidStatusRepo;

    private final YoqlamaRepo yoqlamaRepo;
    private final PaymentRepo paymentRepo;
    private final DoOrNotRepo doOrNotRepo;


    public ResPupil getOnePupil(User user){
        return ResPupil.builder()
                .id(user.getId())
                .firsName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    @Override
    public ApiResponse addPupil(ReqPupil reqPupil) {
        if (!userRepo.existsUserByPhoneNumber(reqPupil.getPhoneNumber())) {
            Role role = roleRepo.findById(1).get();
            Optional<Course> byId = courseRepo.findById(reqPupil.getCoursesId());
            LidStatus lidStatus = lidStatusRepo.findById(reqPupil.getLidStatusId()).get();
            if (byId.isPresent()) {
                Course course = byId.get();
                User build = User.builder()
                        .phoneNumber(reqPupil.getPhoneNumber())
                        .enabled(true)
                        .accauntNonExpired(true)
                        .accountNonLocked(true)
                        .credintialNonExpired(true)
                        .lidStatus(lidStatus)
                        .middleName(reqPupil.getMiddleName())
                        .firstName(reqPupil.getFirstName())
                        .lastName(reqPupil.getLastName())
                        .middleName(reqPupil.getMiddleName())
                        .role(Collections.singletonList(role))
                        .password(reqPupil.getPassword())
                        .build();
                User save = userRepo.save(build);
                Date date = new Date();
                Payment payment = new Payment(Collections.singletonList(save), date);
                int beginTime = course.getCourseBeginTime().getDate();
                int paymentTime = payment.getPaymentTime().getDate();
                if (beginTime < paymentTime) {
                    int otibeKetganDarsKuni = paymentTime - beginTime;
                    int otibKetganDarsSoni = otibeKetganDarsKuni / 2;
                    double ayrilibtashlanadiganPul = otibKetganDarsSoni * course.getPriceForOneday();
                    double umumiySumma = course.getPrice() - ayrilibtashlanadiganPul;
                    payment.setHowMuch(umumiySumma);
                    payment.setQoldiqSumma(umumiySumma);
                    DoOrNot doOrNot = doOrNotRepo.findById(1).get();
                    Yoqlama yoqlama = new Yoqlama(true, doOrNot);
                    build.setYoqlama(Collections.singletonList(yoqlama));
                    build.setCourses(Collections.singletonList(course));
                    yoqlamaRepo.save(yoqlama);
                    paymentRepo.saveAndFlush(payment);
                    return new ApiResponse("siz " + course + " kursini tanladingiz. To'lashingiz kerak bo'lgan summa: " + payment, true);
                }
                payment.setHowMuch(course.getPrice());
                payment.setQoldiqSumma(payment.getHowMuch());
                DoOrNot doOrNot = doOrNotRepo.findById(1).get();
                Yoqlama yoqlama = new Yoqlama(true, doOrNot);
                build.setYoqlama(Collections.singletonList(yoqlama));
                build.setCourses(Collections.singletonList(course));
                paymentRepo.saveAndFlush(payment);
                yoqlamaRepo.save(yoqlama);
                userRepo.save(build);
                return new ApiResponse("siz " + course + " ushbu kursni tanladingiz To'lashingiz kerak bo'lgan summa: " + payment, true);
            }
            return new ApiResponse("bunday course mavjud emas", false);
        }
        return new ApiResponse("bunday telefon raqamli foydlanuvchi bizning o'quv markazda mavjud", false);
    }

    public ApiResponse getPupilPage(Integer page, Integer size){
        try {
            if (page < 0){
                throw new BadRequestExeption("page 0dan kichik bo'lishi mumkin emas");
            }
            if (size < 1){
                throw  new BadRequestExeption("size 1dan kam bo'lmasligi lozim");
            }
            Pageable pageable = PageRequest.of(page, size);
            Page<User> all = userRepo.findAll(pageable);
            return new ApiResponse("pupil pageable", true, new ResPagable(page, size, all.getTotalPages(), all.getTotalElements(), all.stream().map(this::getOnePupil).collect(Collectors.toList())));
        }catch (IllegalArgumentException e){
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
