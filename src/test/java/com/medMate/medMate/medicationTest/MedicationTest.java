package com.medMate.medMate.medicationTest;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.repositories.MedicationRepository;
import com.medMate.medMate.medications.dto.MedicationRequest;
import com.medMate.medMate.medications.service.MedicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class MedicationTest {
    @Autowired
    MedicationService medicationService;
    @Autowired
    private  MedicationRepository medicationRepository;
    @Test
    public void testToCreateAMedication(){
        MedicationRequest medicationRequest = new MedicationRequest();
//        medicationService.createMedication()
        populate();

    }
    private void populate(){
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
            Medication medication = new Medication();
            int index = random.nextInt(3);

            medication.setMedicationName(medicationName.get(index));
            medication.setMedicationForm(medicationForm.get(index));
            medication.setMedicationPurpose(medicationPurpose.get(index));

            medicationRepository.save(medication);
        }


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


