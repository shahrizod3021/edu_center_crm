package edu.center.edu_center.Controller;


import edu.center.edu_center.Service.AdminService;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroup;
import edu.center.edu_center.payload.ReqGroupforJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/{id}")
    public HttpEntity<?> createGroup(@PathVariable Integer id, @RequestBody ReqGroupforJoin reqGroup) {
        ApiResponse group = adminService.createGroup(id, reqGroup);
        return ResponseEntity.status(group.isSuccess() ? 200 : 409).body(group);
    }
}
