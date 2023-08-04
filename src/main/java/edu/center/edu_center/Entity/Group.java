package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
@Builder
public class Group extends AbsNameEntity {

    @ManyToOne(optional = false)
    private Room room;

    @ManyToOne
    private User teacher;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_pupils",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "pupil_id")}
    )
    private Set<User> pupils;

    @ManyToOne
    private Course course;

    @OneToMany(fetch = FetchType.LAZY)
    private List<WeekDay> weekDays;

    @ManyToOne
//            (fetch = FetchType.LAZY)
    private DayType dayTypes;

//    public Group(Integer id, String name, Room room, Course course, List<WeekDay> weekDays, List<DayType> dayTypes) {
//        super(id, name);
//        this.room = room;
//        this.course = course;
//        this.weekDays = weekDays;
//        this.dayTypes = dayTypes;
//    }
}
