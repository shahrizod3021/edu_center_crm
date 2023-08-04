package edu.center.edu_center.payload;

import edu.center.edu_center.Entity.Course;
import edu.center.edu_center.Entity.LidStatus;
import edu.center.edu_center.Entity.Role;
import edu.center.edu_center.Entity.Yoqlama;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqPupil {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String password;
    private Integer lidStatusId;
    private Integer coursesId;

}
