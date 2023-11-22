package com.medMate.medMate.medications.data.repositories;

import com.medMate.medMate.medications.data.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository  extends JpaRepository<Medication,Long> {
}
