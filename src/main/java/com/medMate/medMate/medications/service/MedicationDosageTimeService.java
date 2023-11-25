package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import com.medMate.medMate.medications.dto.request.MedicationDosageRequest;

import java.util.List;

public interface MedicationDosageTimeService {


    List<MedicationDosageTime>createMedicationDosageTime(List<MedicationDosageRequest> medicationDosageRequest);

}
