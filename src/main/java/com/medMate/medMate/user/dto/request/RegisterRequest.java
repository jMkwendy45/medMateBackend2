package com.medMate.medMate.user.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
