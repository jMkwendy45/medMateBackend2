package com.medMate.medMate.medications.data.repositories;

import com.medMate.medMate.medications.data.models.MedicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule,Long> {
}
