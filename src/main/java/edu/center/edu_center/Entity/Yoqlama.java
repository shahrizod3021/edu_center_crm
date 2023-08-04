package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Yoqlama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean keldiKetdi;

    @ManyToOne
    private DoOrNot doOrNot;

    public Yoqlama(boolean keldiKetdi, DoOrNot doOrNot) {
        this.keldiKetdi = keldiKetdi;
        this.doOrNot = doOrNot;
    }
}
