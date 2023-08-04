package edu.center.edu_center.Service;

import edu.center.edu_center.Entity.Course;
import edu.center.edu_center.Full.CourseFull.CourseFullService;
import edu.center.edu_center.Repository.CourseRepo;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqCourse;
import edu.center.edu_center.payload.ResCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseFullService {

    private final CourseRepo courseRepo;

    @Override
    public List<ResCourse> getCourse() {
        List<ResCourse> courses = new ArrayList<>();
        for (Course course : courseRepo.findAll()) {
            ResCourse build = ResCourse.builder()
                    .id(course.getId())
                    .name(course.getName())
                    .price(course.getPrice())
                    .priceForOneDay(course.getPriceForOneday())
                    .expireDate(course.getExpireDate())
                    .description(course.getDescription())
                    .active(course.isActive())
                    .courseBegin(course.getCourseBeginTime())
                    .build();
            courses.add(build);
        }
        return courses;
    }

    @Override
    public ApiResponse addCourse(ReqCourse reqCourse) {
        if (!courseRepo.existsCourseByNameEqualsIgnoreCase(reqCourse.getName())){
            Date date = new Date();
            Course build = Course.builder()
                    .price(reqCourse.getPrice())
                    .courseBeginTime(date)
                    .active(reqCourse.isActive())
                    .description(reqCourse.getDescription())
                    .priceForOneday(reqCourse.getPriceForOneDay())
                    .expireDate(reqCourse.getExpireDate())
                    .build();
            build.setName(reqCourse.getName());
            courseRepo.save(build);
        return new ApiResponse("Saqlandi", true);
        }
        return new ApiResponse("Bunday course mavjud", false);
    }

    @Override
    public ApiResponse editCourse(Integer id, ReqCourse reqCourse) {
        Optional<Course> byId = courseRepo.findById(id);
        if (byId.isPresent()){
            Date date = new Date();
            Course course = byId.get();
            course.setName(reqCourse.getName());
            course.setCourseBeginTime(date);
            course.setPrice(reqCourse.getPrice());
            course.setDescription(reqCourse.getDescription());
            course.setExpireDate(reqCourse.getExpireDate());
            course.setActive(reqCourse.isActive());
            course.setPriceForOneday(reqCourse.getPriceForOneDay());
            courseRepo.save(course);
            return new ApiResponse("taxrirlandi", true);
        }
        return new ApiResponse("bunday course mavjud emas", false);
    }

    @Override
    public ApiResponse deleteCourse(Integer id) {
        Optional<Course> byId = courseRepo.findById(id);
        if (byId.isPresent()){
            Course course = byId.get();
            courseRepo.delete(course);
            return new ApiResponse("o'chirildi oka", true);
        }
        return new ApiResponse("bunday course topilmadi", false);
    }

    @Override
    public ResCourse getOneCourse(Integer id) {
        Optional<Course> byId = courseRepo.findById(id);
        if (byId.isPresent()){
            Course course = byId.get();
            return ResCourse.builder()
                    .name(course.getName())
                    .priceForOneDay(course.getPriceForOneday())
                    .price(course.getPrice())
                    .expireDate(course.getExpireDate())
                    .description(course.getDescription())
                    .id(course.getId())
                    .courseBegin(course.getCourseBeginTime())
                    .active(course.isActive())
                    .build();
        }
        return null;
    }
}
