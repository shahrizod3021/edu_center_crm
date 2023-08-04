package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsNameEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer roomNumber;
    @Column(nullable = false)
    private Byte pupilSize;

    public Room(Integer roomNumber, Byte pupilSize) {
        this.roomNumber = roomNumber;
        this.pupilSize = pupilSize;
    }
}
