package com.medMate.medMate.user.controller;

import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patientProfile")
@RequiredArgsConstructor
public class PatientProfileController {

        private final PatientProfileService patientProfileService;
        @GetMapping("/{id}")
        public ResponseEntity<PatientProfile> getPatientProfileById(@PathVariable Long id) {
            try {
                PatientProfile patientProfile = patientProfileService.findPatientProfileById(id);
                return new ResponseEntity<>(patientProfile, HttpStatus.OK);
            } catch (NotFoundException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @GetMapping("/user/{userId}")
        public ResponseEntity<PatientProfile> getPatientProfileByUserId(@PathVariable Long userId) {
            try {
                PatientProfile patientProfile = patientProfileService.findPatientProfileByUserId(userId);
                return new ResponseEntity<>(patientProfile, HttpStatus.OK);
            } catch (NotFoundException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @PostMapping("/create")
        public ResponseEntity<PatientProfile> createPatientProfile(@RequestBody User user) {
            PatientProfile patientProfile = patientProfileService.createPatientProfile(user);
            return new ResponseEntity<>(patientProfile, HttpStatus.CREATED);
        }
        @PostMapping("/save")
        public ResponseEntity<PatientProfile> savePatientProfile(@RequestBody PatientProfile patientProfile) {
            PatientProfile savedProfile = patientProfileService.saveProfile(patientProfile);
            return new ResponseEntity<>(savedProfile, HttpStatus.OK);
        }
    @PostMapping("/patients/{patientProfileId}/doctors/{emailAdress}")
    public PatientProfile addDoctorToProfile(@PathVariable Long patientProfileId,
                                             @PathVariable String emailAdress) {
        try {
            return patientProfileService.addDoctorToProfile(patientProfileId, emailAdress);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }


}



