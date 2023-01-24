package com.epam.userservice.exception;

public class NotFoundUsersException extends RuntimeException {
   public NotFoundUsersException(Long id){super("User doesn’t exist with given id " + id);}
}
