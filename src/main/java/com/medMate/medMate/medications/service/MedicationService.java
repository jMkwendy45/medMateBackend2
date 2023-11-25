package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;

import java.util.List;

public interface MedicationService {
   MedicationSchedule addMedications(Long medicationId, MedicationRequest medicationRequest, Long userId);
   Medication createMedication(CreateMedicationRequest medicationRequest);

   List<Medication>findAllMedicatons();


   Medication findMedication(Long id);

   List<Medication>getMedicationByUserId(Long userId);
}
