package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.data.repositories.MedicationScheduleRepository;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class MedicationScheduleImplimenation implements MedicationScheduleService {
    private final PatientProfileService patientProfileService;
    private final MedicationScheduleRepository medicationScheduleRepository;



    @Override
    public List<MedicationSchedule> usersSchedules(Long userId) {
//        List<MedicationSchedule> newList = new ArrayList<>();
         PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
//     List<Medication>patientsMedications = foundPatientProfile.getMedications();
//        for (int i = 0; i <=patientsMedications.size() ; i++) {
//         MedicationSchedule medicationSchedule = patientsMedications.get(i).getMedicationSchedule();
//            newList.add(medicationSchedule);
//        }
        return foundPatientProfile.getMedicationSchedules();

    }

    @Override
    public MedicationSchedule takeMedication(Long userId,Long medicationId) {
        PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
        List<Medication>patientsMedications = foundPatientProfile.getMedications();
        MedicationSchedule medicationSchedule= null;
        for (int i = 0; i <patientsMedications.size() ; i++) {
                 if (patientsMedications.get(i).equals(medicationId)){
//                     medicationSchedule  =  patientsMedications.get(i).getMedicationSchedule();
//                  medicationSchedule.setIsTaken(true);
                  medicationScheduleRepository.save(medicationSchedule);
                 }

        }
        return medicationSchedule;
    }

}
