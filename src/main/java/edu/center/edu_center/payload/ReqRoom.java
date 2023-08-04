package edu.center.edu_center.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqRoom {
    private String name;

    private Integer roomNumber;
    private Byte pupilSize;


}
