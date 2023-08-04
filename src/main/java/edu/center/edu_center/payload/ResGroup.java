package edu.center.edu_center.payload;

import edu.center.edu_center.Entity.*;
import lombok.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResGroup {
    private Integer id;
    private String name;
    private Room room;
    private User teacher;
    private Set<User> pupil = new HashSet<>();
    private Course course;
    private List<WeekDay> weekDay = new ArrayList<>();
    private DayType dayTypes;

}
