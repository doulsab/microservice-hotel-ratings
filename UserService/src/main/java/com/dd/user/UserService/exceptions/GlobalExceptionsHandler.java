package com.dd.user.UserService.exceptions;

import com.dd.user.UserService.playload.StatusReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    // Method for Resource not found exception.

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StatusReport> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String msg = ex.getMessage();
        StatusReport statusReport = StatusReport.builder().message(msg).status(true).statusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(statusReport, HttpStatus.NOT_FOUND);
    }
}
