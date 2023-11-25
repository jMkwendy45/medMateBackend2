package com.medMate.medMate.auth.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDoctorRequest {
    private String email;
    private String password;
}
