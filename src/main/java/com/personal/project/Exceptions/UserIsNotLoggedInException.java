package com.personal.project.Exceptions;

public class UserIsNotLoggedInException extends RuntimeException{
    public UserIsNotLoggedInException(String message) {
        super(message);
    }
}
