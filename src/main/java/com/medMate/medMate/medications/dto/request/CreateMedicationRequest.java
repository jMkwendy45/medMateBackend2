package com.medMate.medMate.medications.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateMedicationRequest {
    private String medicationName;
    private String medicationForm;
    private String medicationPurpose;
}
