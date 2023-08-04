package edu.center.edu_center.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReqLogin {
    private String phoneNumber;
    private String password;
}
