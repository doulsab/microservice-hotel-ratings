package com.dd.hotel.HotelService.exceptions;

import com.dd.hotel.HotelService.exceptions.reports.SendReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionsHandler {

    // Method to execute the ResourceNotFoundException

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<SendReport> handleResourceNotFoundException(ResourceNotFoundException exception) {
        String message = exception.getMessage();
        SendReport build = SendReport.builder().message(message).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
    }

}
