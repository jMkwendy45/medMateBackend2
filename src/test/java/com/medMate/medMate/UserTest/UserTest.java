package com.medMate.medMate.UserTest;

import com.medMate.medMate.auth.dto.request.RegisterDoctorRequest;
import com.medMate.medMate.auth.service.AuthenticationService;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.user.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTest {
    @Autowired
    AuthenticationService authenticationService;

    @Test
    public void createAPatientUser(){
      RegisterRequest user   =RegisterRequest.builder().firstname("olu")
                .email("test@gmail.com")
                .password("12345").
                build();
      authenticationService.register(user);
      assertNotNull(user);
    }

    @Test
    public void registerAMedicalPractioner(){
        RegisterDoctorRequest doctor   = RegisterDoctorRequest.builder()
                .email("test4@gmail.com")
                .password("12345").
                build();
        authenticationService.registerDoctor(doctor);
        assertNotNull(doctor);
        
    }

}
