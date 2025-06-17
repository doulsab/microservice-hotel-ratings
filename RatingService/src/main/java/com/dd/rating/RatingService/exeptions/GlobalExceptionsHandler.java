package com.dd.rating.RatingService.exeptions;

import com.dd.rating.RatingService.entities.StatusReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    // Method to throw the error with status code...
    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<StatusReport> ratingNotFoundExceptionHandler(RatingNotFoundException ex) {
        String message = ex.getMessage();
        StatusReport response = StatusReport.builder().responseMessage(message).statusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
