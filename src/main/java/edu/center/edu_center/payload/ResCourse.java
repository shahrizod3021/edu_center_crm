package edu.center.edu_center.payload;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResCourse {
    private Integer id;

    private String name;
    private Double price;
    private Byte expireDate;
    private String description;
    private boolean active;
    private Date courseBegin;
    private double priceForOneDay;
}
