package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;

import java.util.List;

public interface MedicationService {
   Medication addMedications(Long medicationId,MedicationRequest medicationRequest,Long userId);
   Medication createMedication(CreateMedicationRequest medicationRequest);

   List<Medication>findAllMedicatons();


   Medication findMedication(Long id);



}
