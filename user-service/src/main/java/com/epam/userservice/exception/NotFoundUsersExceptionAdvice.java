package com.epam.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundUsersExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundUsersException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String postsNotFound(NotFoundUsersException e){
        return e.getMessage();
    }

}
