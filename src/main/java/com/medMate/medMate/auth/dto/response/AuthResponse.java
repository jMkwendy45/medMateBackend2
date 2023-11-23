package com.medMate.medMate.auth.dto.response;

import java.time.LocalDateTime;

public class AuthResponse extends BaseResponse{
    public AuthResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp, AuthenticationResponse response) {
        super(isSuccessful, responseCode, message, timeStamp);
    }
}
