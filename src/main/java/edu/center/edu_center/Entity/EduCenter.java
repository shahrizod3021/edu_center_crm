package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EduCenter extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private UUID logo;

    private double foyda;

}
