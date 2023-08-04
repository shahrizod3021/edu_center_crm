package edu.center.edu_center.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResPupil
{
 private UUID id;
 private String firsName;
 private String lastName;
 private String middleName;
 private String phoneNumber;

}
