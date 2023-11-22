package com.medMate.medMate.user.services;

import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.repositories.PatientProfileRepository;

public interface PatientProfileService {



    PatientProfile findPatientProfile(Long id);
    PatientProfile saveProfile(PatientProfile patientProfile);
}
