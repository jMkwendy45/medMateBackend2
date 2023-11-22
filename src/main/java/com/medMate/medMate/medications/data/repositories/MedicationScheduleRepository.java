package com.medMate.medMate.medications.data.repositories;

import com.medMate.medMate.medications.data.models.MedicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule,Long> {
}
