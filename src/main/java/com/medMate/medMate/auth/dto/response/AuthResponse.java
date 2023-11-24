package com.medMate.medMate.auth.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AuthResponse extends BaseResponse{
    private AuthenticationResponse response;
    public AuthResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp, AuthenticationResponse response) {
        super(isSuccessful, responseCode, message, timeStamp);
        this.response = response;
    }
}
