package edu.center.edu_center.Service;


import edu.center.edu_center.Entity.Course;
import edu.center.edu_center.Entity.Group;
import edu.center.edu_center.Entity.User;
import edu.center.edu_center.Full.AdminFull.AdminServiceFull;
import edu.center.edu_center.Repository.GroupRepo;
import edu.center.edu_center.Repository.UserRepo;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroupforJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminService implements AdminServiceFull {

    private final GroupRepo groupRepo;

    private final UserRepo userRepo;

    @Override
    public ApiResponse createGroup(Integer id, ReqGroupforJoin reqGroup) {
        Optional<Group> byId1 = groupRepo.findById(id);
        Optional<User> byId = userRepo.findById(reqGroup.getPupilId());
        if (byId.isPresent()) {
            User user = byId.get();
            if (byId1.isPresent()) {
                Group group = byId1.get();
                for (Course cours : user.getCourses()) {
                    if (cours.equals(group.getCourse())) {
                        group.getPupils().add(user);
                        groupRepo.save(group);
                        return new ApiResponse("gruh ma'lumotlari saqlab qolindi", true);
                    }
                    return new ApiResponse("ushbu userni bu kursga qo'shib bo'lmaydi chunki bu foydlanuvchi siz qo'shayotgan gruhning o'rganayotgan kursi haqida bilmaydi va ushbu kursni umuman sotib olmagan", false);
                }
            }
            return new ApiResponse("bunday gruh mavjud emas", false);
        }
        return new ApiResponse("bunday o'quvchi topilmadi", false);
    }
}

