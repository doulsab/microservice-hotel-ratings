package com.dd.user.UserService.playload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusReport {
    private String message;
    private boolean status;
    private HttpStatus statusCode;
}
