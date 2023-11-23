package com.medMate.medMate.medications.dto;

import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {
    private Integer dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime firstDoseTime;
    @Enumerated(EnumType.STRING)
    private MedicationFrequency medicationFrequency;
    @Enumerated(EnumType.STRING)
    private MedicationRequirement medicationRequirement;


}
