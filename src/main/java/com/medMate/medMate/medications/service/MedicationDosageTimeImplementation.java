package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import com.medMate.medMate.medications.data.repositories.MedicationDosageTimeRepository;
import com.medMate.medMate.medications.dto.request.MedicationDosageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationDosageTimeImplementation implements MedicationDosageTimeService{
    private final MedicationDosageTimeRepository medicationDosageTimeRepository;
    @Override
    public List<MedicationDosageTime> createMedicationDosageTime(List<MedicationDosageRequest> medicationDosageRequest) {
        List<MedicationDosageTime> medicationDosageTimes = new ArrayList<>();
        System.out.println(medicationDosageRequest.size());
        for (int i = 0; i <medicationDosageRequest.size(); i++) {
            MedicationDosageTime medicationDosageTime = new MedicationDosageTime();
            medicationDosageTime.setMedicationRequirement(medicationDosageRequest.get(i).getMedicationRequirement());
            medicationDosageTime.setDosageTime(medicationDosageRequest.get(i).getDosageTime());
            medicationDosageTime.setAmountOfPill(medicationDosageRequest.get(i).getAmountOfPill());
            medicationDosageTime.setIsTaken(false);
            medicationDosageTimeRepository.save(medicationDosageTime);
            medicationDosageTimes.add(medicationDosageTime);
            System.out.println("i loop");
        }
        return medicationDosageTimes;
    }

}
