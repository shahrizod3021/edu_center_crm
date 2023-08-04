package edu.center.edu_center.Full.CourseFull;

import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqCourse;
import edu.center.edu_center.payload.ResCourse;

import java.util.ArrayList;
import java.util.List;

public interface CourseFullService {
    List<ResCourse> getCourse();

    ApiResponse addCourse(ReqCourse reqCourse);

    ApiResponse editCourse(Integer id, ReqCourse reqCourse);

    ApiResponse deleteCourse(Integer id);

    ResCourse getOneCourse(Integer id);
}
