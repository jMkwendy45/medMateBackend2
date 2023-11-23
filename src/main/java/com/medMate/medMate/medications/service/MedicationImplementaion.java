package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.data.repositories.MedicationRepository;
import com.medMate.medMate.medications.data.repositories.MedicationScheduleRepository;
import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.MEDICATION_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class MedicationImplementaion  implements MedicationService{
    private  final MedicationRepository medicationRepository;
    private  final MedicationScheduleRepository medicationScheduleRepository;

    private final PatientProfileService patientProfileService;
    @Override
    public Medication addMedications(Long medicationId,MedicationRequest medicationRequest,Long userId) {
        Medication foundMedication = findMedication(medicationId);


         PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setDosage(medicationRequest.getDosage());
        medicationSchedule.setFrequency(medicationRequest.getMedicationFrequency());
        medicationSchedule.setStartDate(LocalDate.from(LocalDateTime.now()));
        medicationSchedule.setEndDate(LocalDate.from(LocalDateTime.now()));
        medicationSchedule.setMedicationRequirement(medicationRequest.getMedicationRequirement());
        medicationSchedule.setMedication(foundMedication);
        medicationScheduleRepository.save(medicationSchedule);
        foundPatientProfile.setMedications(addMedication(foundMedication, foundPatientProfile));
        patientProfileService.saveProfile(foundPatientProfile);
        return foundMedication;
    }

    private List<Medication> addMedication(Medication medication, PatientProfile patientProfile){
        List<Medication> medications = patientProfile.getMedications();
        medications.add(medication);
        return medications;

    }
    @Override
    public Medication createMedication(CreateMedicationRequest medicationRequest) {
        Medication medication = new Medication();
        medication.setMedicationName(medicationRequest.getMedicationName());
        medication.setMedicationForm(medicationRequest.getMedicationForm());
        medication.setMedicationPurpose(medicationRequest.getMedicationPurpose());
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
