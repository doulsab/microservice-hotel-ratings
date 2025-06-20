package com.dd.hotel.HotelService.exceptions.reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendReport {
    private String message;
    private HttpStatus httpStatus;
}
