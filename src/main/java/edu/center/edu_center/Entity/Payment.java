package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsEntity;
import edu.center.edu_center.Entity.AbsEntities.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private double howMuch;

    @ManyToMany
    private List<User> pupil;

    private Date paymentTime;

    private double qoldiqSumma;

    public Payment(List<User> pupil, Date paymentTime) {
        this.pupil = pupil;
        this.paymentTime = paymentTime;
    }

}
