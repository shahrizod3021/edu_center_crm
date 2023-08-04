package edu.center.edu_center.Controller;

import edu.center.edu_center.Service.GroupService;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqGroup;
import edu.center.edu_center.payload.ResGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public HttpEntity<?> getGroup(){
        List<ResGroup> group = groupService.getGroup();
        return ResponseEntity.ok(group);
    }

    @PostMapping
    public HttpEntity<?> addGroup(@RequestBody ReqGroup reqGroup){
        ApiResponse apiResponse = groupService.addGroup(reqGroup);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editGroup(@PathVariable  Integer id, @RequestBody ReqGroup reqGroup){
        ApiResponse apiResponse = groupService.editGroup(id, reqGroup);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGroup(@PathVariable Integer id){
        ApiResponse apiResponse = groupService.deleteGroup(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOneGroup(@PathVariable Integer id){
        ResGroup oneGroup = groupService.getOneGroup(id);
        return ResponseEntity.status(oneGroup == null ? 409 : 200).body(oneGroup);
    }
}
