package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.dto.MedicationRequest;
import com.medMate.medMate.medications.enums.MedicationFrequency;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicationImplementaion  implements MedicationService{


    @Override
    public List<Medication> addMedications(MedicationRequest medicationRequest) {
        Medication medication = new Medication();
        medication.setMedicationName(medication.getMedicationName());
        medication.setMedicationForm(medication.getMedicationForm());
        medication.setMedicationPurpose(medication.getMedicationPurpose());


        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setDosage(medicationRequest.getDosage());
        medicationSchedule.setFrequency(MedicationFrequency.ONCE_A_DAY);
        medicationSchedule.setFrequency(MedicationFrequency.TWICE_A_DAY);
        medicationSchedule.setFrequency(MedicationFrequency.THREE_TIMES_A_DAY);
        medicationSchedule.setFrequency(MedicationFrequency.MORE_THAN_THREE_TIMES_A_DAY);
        medicationSchedule.setFrequency(MedicationFrequency.ONLY_AS_NEEDED);
        medicationSchedule.setDosage(medicationRequest.getDosage());
        medicationSchedule.setStartDate(LocalDate.from(LocalDateTime.now()));
        medicationSchedule.setEndDate(LocalDate.from(LocalDateTime.now()));




        return null;
    }
}
