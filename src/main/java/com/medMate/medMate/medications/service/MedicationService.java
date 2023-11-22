package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.dto.MedicationRequest;
import com.medMate.medMate.user.data.models.PatientProfile;

import java.util.List;

public interface MedicationService {
   Medication addMedications(Long medicationId,MedicationRequest medicationRequest,Long id);
   Medication createMedication(MedicationRequest medicationRequest);

   List<Medication>findAllMedicatons();


   Medication findMedication(Long id);



}
