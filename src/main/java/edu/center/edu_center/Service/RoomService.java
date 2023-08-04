package edu.center.edu_center.Service;

import edu.center.edu_center.Entity.Room;
import edu.center.edu_center.Full.RoomFull.RoomFullService;
import edu.center.edu_center.Repository.RoomRepo;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqRoom;
import edu.center.edu_center.payload.ResRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements RoomFullService {

    private final RoomRepo roomRepo;


    @Override
    public List<ResRoom> getRooms() {
        return null;
    }

    @Override
    public ApiResponse addRoom(ReqRoom room) {
        if (!roomRepo.existsRoomByRoomNumber(room.getRoomNumber())) {
            Room room1 = new Room(room.getRoomNumber(), room.getPupilSize());
            roomRepo.save(room1);
            return new ApiResponse("hona saqlandi", true);
        }
        return new ApiResponse("bunday raqamli hona mavjud", false);
    }

    @Override
    public ApiResponse editRoom(Integer id, ReqRoom room) {
        return null;
    }

    @Override
    public ApiResponse deleteRoom(Integer id) {
        return null;
    }

    @Override
    public ResRoom getOneRoom(Integer id) {
        return null;
    }
}
