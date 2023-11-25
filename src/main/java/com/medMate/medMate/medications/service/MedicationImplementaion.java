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

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.MEDICATION_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class MedicationImplementaion  implements MedicationService{
    private  final MedicationRepository medicationRepository;
    private  final MedicationScheduleRepository medicationScheduleRepository;

    private final PatientProfileService patientProfileService;
    private final MedicationDosageTimeService medicationDosageTimeService;
    @Override
    public MedicationSchedule addMedications(Long medicationId,MedicationRequest medicationRequest,Long userId) {
        Medication foundMedication = findMedication(medicationId);
        PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setFrequency(medicationRequest.getMedicationFrequency());
        medicationSchedule.setStartDate(medicationRequest.getStartDate());
        medicationSchedule.setEndDate(medicationRequest.getEndDate());
        medicationSchedule.setMedication(foundMedication);
        medicationSchedule.setDosageTimes( medicationDosageTimeService.createMedicationDosageTime(medicationRequest.getDosageTimes()));
        medicationScheduleRepository.save(medicationSchedule);
       foundPatientProfile.setMedications(addMedication(foundMedication, foundPatientProfile));
       foundPatientProfile.setMedicationSchedules(addSchedule(medicationSchedule, foundPatientProfile));
       patientProfileService.saveProfile(foundPatientProfile);
        System.out.println(foundMedication);
        return  medicationSchedule;

    }
    private List<Medication> addMedication(Medication medication, PatientProfile patientProfile){
        List<Medication> medications = patientProfile.getMedications();
        for(int index = 1; index <medications.size(); index++){
            if (Objects.equals(medications.get(index).getId(), medication.getId())){
                throw new NotFoundException("you have added this medication already");
            }
        }
        medications.add(medication);

        return medications;
    }
    private List<MedicationSchedule> addSchedule(MedicationSchedule medicationSchedule, PatientProfile patientProfile){
        List<MedicationSchedule> schedules = patientProfile.getMedicationSchedules();
        for(int index = 0; index <schedules.size(); index++){
            if (Objects.equals(schedules.get(index).getId(), medicationSchedule.getId())){
                throw new NotFoundException("you have added this medication already");
            }
            else {
                schedules.add(medicationSchedule);

            }
        }
        return schedules;
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
