package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.Enums.DoOrNotName;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DoOrNot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private DoOrNotName doOrNotName;

    public DoOrNot(DoOrNotName value) {
        this.doOrNotName = value;
    }
}
