package com.medMate.medMate.user.services;

import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.repositories.PatientProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.MEDICATION_NOT_FOUND;
import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.PATIENT_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class PatientProfileImplementaion implements PatientProfileService{
    private final PatientProfileRepository patientProfileRepository;

    @Override
    public PatientProfile findPatientProfile(Long id) {
        PatientProfile foundPatient=patientProfileRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(PATIENT_NOT_FOUND.name()));
        return  foundPatient;
    }

    @Override
    public PatientProfile saveProfile(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }
}
