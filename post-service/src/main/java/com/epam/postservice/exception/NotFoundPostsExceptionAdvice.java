package com.epam.postservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class NotFoundPostsExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundPostsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String postsNotFound(NotFoundPostsException e){
        return e.getMessage();
    }

}
