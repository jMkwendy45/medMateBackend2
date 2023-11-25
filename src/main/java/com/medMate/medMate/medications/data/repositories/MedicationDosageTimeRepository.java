package com.medMate.medMate.medications.data.repositories;

import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDosageTimeRepository extends JpaRepository<MedicationDosageTime,Long> {
}
