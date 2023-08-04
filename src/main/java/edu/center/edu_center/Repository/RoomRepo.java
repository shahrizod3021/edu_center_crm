package edu.center.edu_center.Repository;

import edu.center.edu_center.Entity.Room;
import edu.center.edu_center.Projection.CustomRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "room", collectionResourceRel = "list", excerptProjection = CustomRoom.class)
public interface RoomRepo extends JpaRepository<Room, Integer> {
    boolean existsRoomByRoomNumber(Integer roomNumber);
}
