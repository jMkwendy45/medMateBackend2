package com.medMate.medMate.auth.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlreadyExistException  extends RuntimeException{
    public AlreadyExistException(String message){
        super(message);
    }

}
