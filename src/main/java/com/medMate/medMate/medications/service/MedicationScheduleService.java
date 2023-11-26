package com.medMate.medMate.medications.service;

import com.medMate.medMate.medications.data.models.MedicationSchedule;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface MedicationScheduleService {
    List<MedicationSchedule>usersSchedules(Long userId);
    List<MedicationSchedule>getAllSchedules();

    MedicationSchedule takeMedication(Long userId,Long scheduleId, Long dosageId);




}
