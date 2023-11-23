package com.medMate.medMate.user.services;

import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.user.data.models.PatientProfile;

public interface PatientProfileService {
    PatientProfile findPatientProfileById(Long id);
    PatientProfile findPatientProfileByUserId(Long userId);
    PatientProfile saveProfile(PatientProfile patientProfile);

    PatientProfile createPatientProfile(User user);


}
