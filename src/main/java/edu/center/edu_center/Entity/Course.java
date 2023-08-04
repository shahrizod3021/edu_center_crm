package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsNameEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course extends AbsNameEntity {
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Byte expireDate;

    @Column(nullable = false, length = 10000)
    private String description;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Date courseBeginTime;

    private double priceForOneday;
}
