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
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println(medicationId);
        System.out.println(userId);
        Medication foundMedication = findMedication(medicationId);
         PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setDosage(medicationRequest.getDosage());
        medicationSchedule.setFrequency(medicationRequest.getMedicationFrequency());
         medicationSchedule.setFirstDoseTime(medicationRequest.getFirstDoseTime());
        medicationSchedule.setStartDate(medicationRequest.getStartDate());
        medicationSchedule.setEndDate(medicationRequest.getEndDate());


        medicationSchedule.setMedicationRequirement(medicationRequest.getMedicationRequirement());
        medicationSchedule.setMedication(foundMedication);
        medicationScheduleRepository.save(medicationSchedule);
        foundMedication.setMedicationSchedule(medicationSchedule);
        medicationRepository.save(foundMedication);

       foundPatientProfile.setMedications(addMedication(foundMedication, foundPatientProfile));
        System.out.println(foundMedication);
        return  foundMedication;

    }
    private List<Medication> addMedication(Medication medication, PatientProfile patientProfile){
        List<Medication> medications = patientProfile.getMedications();
//        for(int index = 1; index <medications.size(); index++){
//            if (Objects.equals(medications.get(index).getId(), medication.getId())){
//                throw new NotFoundException("you have added this medication already");
//            }
//            else {
//            }
        //}
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
    @Override
    public List<Medication> getMedicationByUserId(Long userId) {
     PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
        return  foundPatientProfile.getMedications();
    }


}
