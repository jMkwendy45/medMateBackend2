package com.medMate.medMate.user.dto.response;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.auth.dto.User;

import java.time.LocalDateTime;

public class RegisterUserResponse extends BaseResponse {
    private User user;

    public RegisterUserResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp, User user) {
        super(isSuccessful, responseCode, message, timeStamp);
        this.user = user;
    }
}
