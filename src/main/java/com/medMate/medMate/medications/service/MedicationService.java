package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.dto.MedicationRequest;

import java.util.List;

public interface MedicationService {
   List<Medication>addMedications(MedicationRequest medicationRequest);

}
