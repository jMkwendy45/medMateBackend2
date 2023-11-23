package com.medMate.medMate.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class BaseResponse {
    private boolean isSuccessful;
    private int responseCode;
    private String message;
    private LocalDateTime timeStamp = LocalDateTime.now();
}
