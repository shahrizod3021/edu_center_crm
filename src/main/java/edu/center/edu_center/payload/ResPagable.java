package edu.center.edu_center.payload;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResPagable {
    private Integer page;
    private Integer size;
    private Integer totalPage;
    private Long totalElement;
    private Object object;

}
