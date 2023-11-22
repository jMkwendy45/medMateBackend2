package com.medMate.medMate.medications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {
    private String medicationName;
    private String medicationForm;
    private String medicationPurpose;
    private Integer dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime firstDoseTime;

}
