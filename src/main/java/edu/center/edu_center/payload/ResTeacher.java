package edu.center.edu_center.payload;

import edu.center.edu_center.Entity.Course;
import edu.center.edu_center.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResTeacher {
    private UUID id;
    private String firstname;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String password;
    private List<Course> courses = new ArrayList<>();

    private List<Role> roles = new ArrayList<>();
}
