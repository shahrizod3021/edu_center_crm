package edu.center.edu_center.Full.RoomFull;

import edu.center.edu_center.Entity.LidStatus;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqRoom;
import edu.center.edu_center.payload.ResRoom;

import java.util.List;

public interface RoomFullService {

    List<ResRoom> getRooms();

    ApiResponse addRoom(ReqRoom room);

    ApiResponse editRoom(Integer id,ReqRoom room);

    ApiResponse deleteRoom(Integer id);

    ResRoom getOneRoom(Integer id);
}
