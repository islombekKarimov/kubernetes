package com.epam.postservice.exception;


public class UserServiceException extends RuntimeException {

    public UserServiceException(Long id) {
        super("User Service connection Error userId: " + id);
    }

}
