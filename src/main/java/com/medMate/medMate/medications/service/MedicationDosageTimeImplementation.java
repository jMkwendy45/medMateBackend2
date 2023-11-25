package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import com.medMate.medMate.medications.dto.request.MedicationDosageRequest;

import java.util.List;

public class MedicationDosageTimeImplementation implements MedicationDosageTimeService{
    @Override
    public List<MedicationDosageTime> createMedicationDosageTime(List<MedicationDosageRequest> medicationDosageRequest) {
        for (int i = 1; i <medicationDosageRequest.size(); i++) {
            MedicationDosageTime medicationDosageTime = new MedicationDosageTime();
//            medicationDosageTime.setMedicationRequirement(medicationDosageRequest.get());

        }


        return null;
    }

}
