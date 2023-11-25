package com.medMate.medMate.medications.controller;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;
import com.medMate.medMate.medications.dto.response.CreateMedicationResponse;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.medications.service.MedicationService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/medications")
@AllArgsConstructor
@CrossOrigin("*")
public class MedicationController {
    private  final MedicationService medicationService;

    @PostMapping("/createMedications")
    public ResponseEntity<BaseResponse> createMedications(@RequestBody CreateMedicationRequest medicationRequest){
        Medication response = medicationService.createMedication(medicationRequest);
        return new ResponseEntity<>(
                new CreateMedicationResponse(true, HttpStatus.CREATED.value(), "successful",
                        LocalDateTime.now(), response)
                ,HttpStatus.CREATED);
    }
    @PostMapping("/addMedication/{medicationId}/{patientId}/")
    public ResponseEntity<Medication> addMedication(
             @PathVariable Long medicationId,
            @RequestBody MedicationRequest medicationRequest,
             @PathVariable Long patientId) {
        try {
            Medication addedMedication = medicationService.addMedications(medicationId, medicationRequest, patientId);
            return new ResponseEntity<>(addedMedication, HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
        public ResponseEntity<List<Medication>> getAllMedications() {
            List<Medication> medications = medicationService.findAllMedicatons();
            return new ResponseEntity<>(medications, HttpStatus.OK);
        }

        @GetMapping("/{medicationId}")
        public ResponseEntity<Medication> getMedicationById(@PathVariable Long medicationId) {
            try {
                Medication medication = medicationService.findMedication(medicationId);
                return new ResponseEntity<>(medication, HttpStatus.OK);
            } catch (NotFoundException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }



