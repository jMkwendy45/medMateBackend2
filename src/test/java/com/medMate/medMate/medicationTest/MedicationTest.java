package com.medMate.medMate.medicationTest;

import com.medMate.medMate.medications.dto.request.CreateMedicationRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;
import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import com.medMate.medMate.medications.service.MedicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MedicationTest {
    @Autowired
    MedicationService medicationService;

    @Test
    public void testToCreateAMedication(){
    }
    @Test
    public void populateAndTestToCreateMedication(){
        List <String> medicationName = new ArrayList<>(Arrays.asList("Paracetamol","Armethem","Aspirin"));

        List <String> medicationForm = new ArrayList<>(){{
            add("Paracetamol");
            add("Armethem");
            add("Aspirin");
        }};
        List <String> medicationPurpose = new ArrayList<>(){{
            add("headache");
            add("fever");
            add("pain");
        }};
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            CreateMedicationRequest medication = new CreateMedicationRequest();
            int index = random.nextInt(3);

            medication.setMedicationName(medicationName.get(index));
            medication.setMedicationForm(medicationForm.get(index));
            medication.setMedicationPurpose(medicationPurpose.get(index));
             medicationService.createMedication(medication);
            assertNotNull(medication);
        }

    }
    @Test
    public void testToAddMedication(){
        MedicationRequest medicationRequest = new MedicationRequest();
        medicationRequest.setDosage(8);
        medicationRequest.setStartDate(String.valueOf(LocalDate.now()));
        medicationRequest.setEndDate(String.valueOf(LocalDate.now()));
        medicationRequest.setMedicationFrequency(MedicationFrequency.ONCE_A_DAY);
        medicationRequest.setMedicationRequirement(MedicationRequirement.AFTER_EATING);
       medicationService.addMedications(10L,medicationRequest,2L);
    }

    }
//
//    @Test
//    @DirtiesContext
//    public void testCreateMedicationList() {
//        // Given
//        List<MedicationRequest> medicationRequests = List.of(
//                new MedicationRequest("Medication1", "Form1", "Purpose1"),
//                new MedicationRequest("Medication2", "Form2", "Purpose2"),
//                new MedicationRequest("Medication3", "Form3", "Purpose3")
//        );
//
//        // When
//        List<Medication> createdMedications = medicationService.createMedicationList(medicationRequests);
//
//        // Then
//        assertEquals(3, createdMedications.size());
//        // Add more assertions if needed
//    }


