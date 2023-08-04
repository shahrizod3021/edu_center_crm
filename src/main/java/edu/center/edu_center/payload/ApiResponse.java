package edu.center.edu_center.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;

    private ResPagable resPagable;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
