package com.medMate.medMate.medications.controller;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.response.AllScheduleResponse;
import com.medMate.medMate.medications.dto.response.CreateMedicationResponse;
import com.medMate.medMate.medications.dto.response.MedicationScheduleResponse;
import com.medMate.medMate.medications.service.MedicationScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medicationschedule")
@AllArgsConstructor
@CrossOrigin("*")
public class MedicationScheduleController {
    private final MedicationScheduleService medicationScheduleService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> findAllMedications(){
        List<MedicationSchedule> response = medicationScheduleService.getAllSchedules();
        return new ResponseEntity<>(
                new AllScheduleResponse(true, HttpStatus.CREATED.value(), "successful",
                        LocalDateTime.now(), response)
                ,HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<MedicationSchedule>> getAllUserMedication(@PathVariable Long userId) {
        List<MedicationSchedule> medications = medicationScheduleService.usersSchedules(userId);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }
    @PostMapping("/takeMedications/{userId}/")
    public ResponseEntity<BaseResponse> takeMedications(@PathVariable Long userId, @RequestParam Long scheduleId,@RequestParam Long dosageTimeId){
        MedicationSchedule response = medicationScheduleService.takeMedication(userId, scheduleId, dosageTimeId);
        return new ResponseEntity<>(
                new MedicationScheduleResponse(true, HttpStatus.CREATED.value(), "successful",
                        LocalDateTime.now(), response)
                ,HttpStatus.CREATED);
    }
}
