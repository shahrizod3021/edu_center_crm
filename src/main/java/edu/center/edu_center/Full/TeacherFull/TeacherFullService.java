package edu.center.edu_center.Full.TeacherFull;

import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqTeacher;
import edu.center.edu_center.payload.ResTeacher;

import java.util.List;

public interface TeacherFullService {

    List<ResTeacher> getTeacher();
    ApiResponse addTeacher(ReqTeacher reqTeacher);

    ApiResponse editTeacher(Integer id, ReqTeacher reqTeacher);

    ApiResponse deleteTeacher(ReqTeacher reqTeacher);

    ResTeacher getOneteacher(Integer id);
}
