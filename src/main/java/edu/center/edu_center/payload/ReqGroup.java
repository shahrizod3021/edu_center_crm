package edu.center.edu_center.payload;

import edu.center.edu_center.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqGroup {
    private String name;
    private Integer roomId;
    private Integer courseId;
    private Integer dayTypesId;
    private UUID teacherId;


}
