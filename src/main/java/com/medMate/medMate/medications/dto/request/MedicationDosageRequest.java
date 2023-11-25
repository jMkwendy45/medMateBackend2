package com.medMate.medMate.medications.dto.request;

import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicationDosageRequest {
    private String dosageTime;
    private String  amountOfPill;
    @Enumerated(value = EnumType.STRING)
    private MedicationRequirement medicationRequirement;
}
