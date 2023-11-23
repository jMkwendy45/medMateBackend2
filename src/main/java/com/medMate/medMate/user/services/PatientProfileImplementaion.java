package com.medMate.medMate.user.services;

import com.medMate.medMate.auth.data.repositories.UserRepository;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.repositories.PatientProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.PATIENT_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class PatientProfileImplementaion implements PatientProfileService{
    private final PatientProfileRepository patientProfileRepository;
    private final UserRepository userRepository;

    @Override
    public PatientProfile findPatientProfileById(Long id) {

        PatientProfile foundPatient=patientProfileRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(PATIENT_NOT_FOUND.name()));
        return  foundPatient;
    }

    @Override
    public PatientProfile findPatientProfileByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        return patientProfileRepository.findPatientProfileByUser(user.get())
                .orElseThrow(()-> new NotFoundException(PATIENT_NOT_FOUND.name()));

    }

    @Override
    public PatientProfile saveProfile(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }

    @Override
    public PatientProfile createPatientProfile(User user) {
        PatientProfile patientProfile = new PatientProfile();
        patientProfile.setMedications(null);
        patientProfile.setUser(user);
        patientProfile.setHealthPractisoner(null);
        return patientProfileRepository.save(patientProfile);
    }

}
