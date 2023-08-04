package edu.center.edu_center.Projection;

import edu.center.edu_center.Entity.Room;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Room.class, name = "CustomRoom")
public interface CustomRoom {
    Integer getId();
    Integer getRoomNumber();

    Byte getPupilSize();

}
