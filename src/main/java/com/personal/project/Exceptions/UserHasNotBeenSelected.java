package com.personal.project.Exceptions;

public class UserHasNotBeenSelected extends RuntimeException{
    public UserHasNotBeenSelected(String message){
        super(message);
    }
}
