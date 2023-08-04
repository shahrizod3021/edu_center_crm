package edu.center.edu_center.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqCourse {
    private String name;
    private Double price;
    private Byte expireDate;
    private String description;
    private boolean active;
    private double priceForOneDay;

}
