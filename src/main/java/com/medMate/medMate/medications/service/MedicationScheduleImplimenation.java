package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.data.repositories.MedicationScheduleRepository;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MedicationScheduleImplimenation implements MedicationScheduleService {
    private final PatientProfileService patientProfileService;
    private final MedicationScheduleRepository medicationScheduleRepository;



    @Override
    public List<MedicationSchedule> usersSchedules(Long userId) {
        return medicationScheduleRepository.findMedicationScheduleByUserId(userId);

    }

    @Override
    public List<MedicationSchedule> getAllSchedules() {
        return medicationScheduleRepository.findAll();
    }

    @Override
    public MedicationSchedule takeMedication(Long userId,Long scheduleId, Long dosageId) {
        List<MedicationSchedule> usersMedicalSchedule = medicationScheduleRepository.findMedicationScheduleByUserId(userId);
        for (int i = 0; i <usersMedicalSchedule.size() ; i++) {
            System.out.println(userId+" "+ scheduleId+ "" +usersMedicalSchedule.get(i).getId());
                 if (usersMedicalSchedule.get(i).getId().equals(scheduleId)){
                     List<MedicationDosageTime> usersDosages = usersMedicalSchedule.get(i).getDosageTimes();
                     for (int index = 0; index < usersDosages.size(); index++){
                         if (Objects.equals(usersDosages.get(index).getId(), dosageId)){
                             usersDosages.get(index).setIsTaken(true);
                             return usersMedicalSchedule.get(i);
                         }


                     }

                 }


        }
        return null;
    }

}
