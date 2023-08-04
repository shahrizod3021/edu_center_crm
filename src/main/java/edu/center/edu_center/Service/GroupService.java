package edu.center.edu_center.Service;

import edu.center.edu_center.Entity.*;
import edu.center.edu_center.Entity.Enums.RoleName;
import edu.center.edu_center.Full.GroupFull.GroupFullService;
import edu.center.edu_center.Repository.*;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroup;
import edu.center.edu_center.payload.ResGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService implements GroupFullService {

    private final DayTypeRepo dayTypeRepo;
    private final GroupRepo groupRepo;
    private final CourseRepo courseRepo;

    private final RoomRepo roomRepo;

    private final UserRepo userRepo;
    private final RoleRepo repo;


    @Override
    public List<ResGroup> getGroup() {
        List<ResGroup> resGroups = new ArrayList<>();
        for (Group group : groupRepo.findAll()) {
            ResGroup build = ResGroup.builder()
                    .id(group.getId())
                    .room(group.getRoom())
                    .name(group.getName())
                    .pupil(group.getPupils())
                    .teacher(group.getTeacher())
                    .course(group.getCourse())
                    .dayTypes(group.getDayTypes())
                    .weekDay(group.getWeekDays())
                    .build();
            resGroups.add(build);
        }
        return resGroups;
    }

    @Override
    public ApiResponse addGroup(ReqGroup reqGroup) {
        if (!groupRepo.existsGroupByNameEqualsIgnoreCase(reqGroup.getName())) {
            Optional<Course> byId = courseRepo.findById(reqGroup.getCourseId());
            if (byId.isPresent()) {
                Optional<Room> byId1 = roomRepo.findById(reqGroup.getRoomId());
                if (byId1.isPresent()) {
                    DayType dayType = dayTypeRepo.findById(reqGroup.getDayTypesId()).get();
                    User user = userRepo.findById(reqGroup.getTeacherId()).get();
                    Role role = repo.findById(2).get();
                    if (user.getRole().get(1).getRoleName().equals(role.getRoleName())) {
                        Course course = byId.get();
                        Room room = byId1.get();
                        Group build = Group.builder()
                                .teacher(user)
                                .course(course)
                                .dayTypes(dayType)
                                .room(room)
                                .build();
                        build.setName(reqGroup.getName());
                        groupRepo.save(build);
                        return new ApiResponse("gruh saqlandi", true);
                    }
                }
                return new ApiResponse("bunday hona topilmadi", false);
            }
            return new ApiResponse("bunday kurs mavjud emas", false);
        }
        return new ApiResponse("bunday gruppa mavjud ", false);
    }

    @Override
    public ApiResponse editGroup(Integer id, ReqGroup reqGroup) {
        Optional<Group> byId = groupRepo.findById(id);
        Room room = roomRepo.findById(reqGroup.getRoomId()).get();
        Course course = courseRepo.findById(reqGroup.getCourseId()).get();
        DayType dayType = dayTypeRepo.findById(reqGroup.getDayTypesId()).get();
        if (byId.isPresent()) {
            Group group = byId.get();
            group.setName(reqGroup.getName());
            group.setRoom(room);
            group.setCourse(course);
            group.setDayTypes(dayType);
            return new ApiResponse("gruh taxrirlandi", true);
        }
        return new ApiResponse("bunday gruh mavjud emas", false);
    }

    @Override
    public ApiResponse deleteGroup(Integer id) {
        Optional<Group> byId = groupRepo.findById(id);
        if (byId.isPresent()) {
            Group group = byId.get();
            groupRepo.delete(group);
            return new ApiResponse("gruh o'chirildi", true);
        }
        return new ApiResponse("bunday gruh mavjud emas", false);

    }

    @Override
    public ResGroup getOneGroup(Integer id) {
        Optional<Group> byId = groupRepo.findById(id);
        if (byId.isPresent()) {
            Group group = byId.get();
            return ResGroup.builder()
                    .id(group.getId())
                    .name(group.getName())
                    .weekDay(group.getWeekDays())
                    .room(group.getRoom())
                    .dayTypes(group.getDayTypes())
                    .course(group.getCourse())
                    .teacher(group.getTeacher())
                    .pupil(group.getPupils())
                    .build();
        }
        return null;
    }
}
