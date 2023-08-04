package edu.center.edu_center.Controller;

import edu.center.edu_center.Service.RoomService;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    private HttpEntity<?> addRoom(@RequestBody ReqRoom reqRoom){
        ApiResponse apiResponse = roomService.addRoom(reqRoom);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
