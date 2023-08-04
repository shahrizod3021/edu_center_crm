package edu.center.edu_center.Controller;

import edu.center.edu_center.Service.CourseService;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqCourse;
import edu.center.edu_center.payload.ResCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public HttpEntity<?> getCourse() {
        List<ResCourse> course = courseService.getCourse();
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public HttpEntity<?> addCourse(@RequestBody ReqCourse reqCourse) {
        ApiResponse apiResponse = courseService.addCourse(reqCourse);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCourse(@PathVariable Integer id, @RequestBody ReqCourse reqCourse){
        ApiResponse apiResponse = courseService.editCourse(id, reqCourse);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCourse(@PathVariable Integer id){
        ApiResponse apiResponse = courseService.deleteCourse(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOneCourse(@PathVariable Integer id){
        ResCourse oneCourse = courseService.getOneCourse(id);
        return ResponseEntity.ok(oneCourse);
    }

}
