package com.medMate.medMate.auth.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
}

