package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.data.repositories.MedicationRepository;
import com.medMate.medMate.medications.data.repositories.MedicationScheduleRepository;
import com.medMate.medMate.medications.dto.MedicationRequest;
import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.repositories.PatientProfileRepository;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.MEDICATION_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class MedicationImplementaion  implements MedicationService{
    private  final MedicationRepository medicationRepository;
    private  final MedicationScheduleRepository medicationScheduleRepository;

    private final PatientProfileService patientProfileService;
    @Override
    public Medication addMedications(Long medicationId,MedicationRequest medicationRequest,Long id) {
        Medication foundMedication = findMedication(medicationId);
         PatientProfile foundPatientProfile = patientProfileService.findPatientProfile(id);
        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setDosage(medicationRequest.getDosage());
        medicationSchedule.setFrequency(medicationRequest.getMedicationFrequency());
        medicationSchedule.setStartDate(LocalDate.from(LocalDateTime.now()));
        medicationSchedule.setEndDate(LocalDate.from(LocalDateTime.now()));
        medicationSchedule.setMedicationRequirement(medicationRequest.getMedicationRequirement());
        medicationSchedule.setMedication(foundMedication);
        medicationScheduleRepository.save(medicationSchedule);
        foundPatientProfile.setMedications(Collections.singletonList(foundMedication));
        patientProfileService.saveProfile(foundPatientProfile);
        return foundMedication;
    }
    @Override
    public Medication createMedication(MedicationRequest medicationRequest) {
        Medication medication = new Medication();
        medication.setMedicationName(medication.getMedicationName());
        medication.setMedicationForm(medication.getMedicationForm());
        medication.setMedicationPurpose(medication.getMedicationPurpose());
        return  medicationRepository.save(medication);
    }

    @Override
    public List<Medication> findAllMedicatons() {
        return medicationRepository.findAll();
    }
    @Override
    public Medication findMedication(Long id) {
      Medication foundMedication =  medicationRepository.findById(id)
              .orElseThrow(()-> new NotFoundException(MEDICATION_NOT_FOUND.name()));
      return foundMedication;
    }


}
