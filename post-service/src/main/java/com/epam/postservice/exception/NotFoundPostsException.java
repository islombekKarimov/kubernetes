package com.epam.postservice.exception;

public class NotFoundPostsException extends RuntimeException {
   public NotFoundPostsException(Long id){super("Posts with such id not found " + id);}
}
