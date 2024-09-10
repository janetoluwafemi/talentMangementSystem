package com.personal.project.Exceptions;

public class CorrectPasswordException extends RuntimeException{
    public CorrectPasswordException(String message){
        super(message);
    }
}
