package com.dd.user.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    //Constructor default
    public ResourceNotFoundException() {
        super("Resource not found in the server!!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
