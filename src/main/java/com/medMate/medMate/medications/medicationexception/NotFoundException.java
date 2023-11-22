package com.medMate.medMate.medications.medicationexception;

import lombok.AllArgsConstructor;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }

}
