package com.dd.rating.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusReport {
    private HttpStatus statusCode;
    private String responseMessage;
}
