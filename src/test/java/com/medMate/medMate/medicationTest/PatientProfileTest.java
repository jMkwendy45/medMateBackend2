package com.medMate.medMate.medicationTest;

import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.user.services.PatientProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientProfileTest {
    @Autowired
    PatientProfileService patientProfileService;
    @Test
    public void createPatientProfileTest() {
        User user = new User();
        user.setEmail("testUser@example.com");
        user.setPassword("password123");
    }


}
