package com.medMate.medMate.medicationTest;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import com.medMate.medMate.medications.dto.request.MedicationRequest;
import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.user.data.models.PatientProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MedicationScheduleTest {

//    @Test
//    public void testToAddAMedication(){
//        Long medicationId = 1L;
//
//        MedicationRequest medicationRequest = new MedicationRequest();
//        medicationRequest.setMedicationFrequency(MedicationFrequency.DAILY);
//        medicationRequest.setStartDate("6");
//        medicationRequest.setEndDate("7");
//        medicationRequest.setDosageTimes(Arrays.asList(new DosageTime(LocalTime.of(8, 0)), new DosageTime(LocalTime.of(16, 0))));
//
//        Long userId = 1L;
//
//        MedicationSchedule medicationSchedule = medicationScheduleService.addMedications(medicationId, medicationRequest, userId);
//
//        assertNotNull(medicationSchedule);
//        assertEquals(medicationRequest.getMedicationFrequency(), medicationSchedule.getFrequency());
//        assertEquals(medicationRequest.getStartDate(), medicationSchedule.getStartDate());
//        assertEquals(medicationRequest.getEndDate(), medicationSchedule.getEndDate());
//       assertEquals(medicationRequest.getDosageTimes().size(), medicationSchedule.getDosageTimes().size());
//
//        Medication foundMedication = medicationRepository.findById(medicationId).get();
//        assertEquals(1, foundMedication.getMedicationSchedules().size());
//
//        PatientProfile foundPatientProfile = patientProfileService.findPatientProfileByUserId(userId);
//       assertEquals(1, foundPatientProfile.getMedicationSchedules().size());
//    }
//
//
//    };
//    @Test
//    public void testToTakeMedication(){
//
//    }
}
