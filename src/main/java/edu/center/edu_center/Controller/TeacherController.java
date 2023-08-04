package edu.center.edu_center.Controller;

import edu.center.edu_center.Service.TeacherServise;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherServise teacherServise;

    @PostMapping
    public HttpEntity<?> addTeacher(@RequestBody ReqTeacher reqTeacher){
        ApiResponse apiResponse = teacherServise.addTeacher(reqTeacher);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
