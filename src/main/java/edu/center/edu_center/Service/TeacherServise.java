package edu.center.edu_center.Service;

import edu.center.edu_center.Entity.Role;
import edu.center.edu_center.Entity.User;
import edu.center.edu_center.Full.TeacherFull.TeacherFullService;
import edu.center.edu_center.Repository.RoleRepo;
import edu.center.edu_center.Repository.UserRepo;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqTeacher;
import edu.center.edu_center.payload.ResTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServise implements TeacherFullService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    @Override
    public List<ResTeacher> getTeacher() {
        return null;
    }

    @Override
    public ApiResponse addTeacher(ReqTeacher reqTeacher) {
        if (!userRepo.existsUserByPhoneNumber(reqTeacher.getPhoneNumber())){
            Role role = roleRepo.findById(2).get();
            User build = User.builder()
                    .phoneNumber(reqTeacher.getPhoneNumber())
                    .firstName(reqTeacher.getFirstname())
                    .lastName(reqTeacher.getLastName())
                    .middleName(reqTeacher.getMiddleName())
                    .password(reqTeacher.getPassword())
                    .courses(reqTeacher.getCourses())
                    .role(Collections.singletonList(role))
                    .build();
            userRepo.save(build);
            return new ApiResponse("teacher saqlandi", true);
        }
        return new ApiResponse("bunday telefon raqamli ustoz mavjud", false);
    }

    @Override
    public ApiResponse editTeacher(Integer id, ReqTeacher reqTeacher) {
        return null;
    }

    @Override
    public ApiResponse deleteTeacher(ReqTeacher reqTeacher) {
        return null;
    }

    @Override
    public ResTeacher getOneteacher(Integer id) {
        return null;
    }
}
