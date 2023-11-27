package com.medMate.medMate.medicationTest;

import com.medMate.medMate.medications.data.models.MedicationDosageTime;
import com.medMate.medMate.medications.dto.request.MedicationDosageRequest;
import com.medMate.medMate.medications.dto.request.MedicationRequest;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import com.medMate.medMate.medications.service.MedicationDosageTimeService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

@SpringBootTest
public class MedicationDosageTimeTest {

    @Autowired
    MedicationDosageTimeService medicationDosageTimeService;
    @Test
    public void createMedicationDosageTimeTest() {

        List<MedicationDosageRequest> medicationDosageRequestList = new ArrayList<>();
        MedicationDosageRequest medicationDosageRequest1 = new MedicationDosageRequest();
        medicationDosageRequest1.setMedicationRequirement(MedicationRequirement.AFTER_EATING);
        medicationDosageRequest1.setDosageTime("Morning");
        medicationDosageRequest1.setAmountOfPill(String.valueOf(1));
        medicationDosageRequestList.add(medicationDosageRequest1);

        MedicationDosageRequest medicationDosageRequest2 = new MedicationDosageRequest();
        medicationDosageRequest2.setMedicationRequirement(MedicationRequirement.AFTER_EATING);
        medicationDosageRequest2.setDosageTime("Evening");
        medicationDosageRequest2.setAmountOfPill(String.valueOf(2));
        medicationDosageRequestList.add(medicationDosageRequest2);


        List<MedicationDosageTime> medicationDosageTimes = medicationDosageTimeService.createMedicationDosageTime(medicationDosageRequestList);
        assertNotNull(medicationDosageTimes);
        Assertions.assertEquals(medicationDosageRequestList.size(), medicationDosageTimes.size());
        for (MedicationDosageTime medicationDosageTime : medicationDosageTimes) {
            assertNotNull(medicationDosageTime);
            assertNotNull(medicationDosageTime.getMedicationRequirement());
            assertNotNull(medicationDosageTime.getDosageTime());
            assertNotNull(medicationDosageTime.getAmountOfPill());
           assertFalse(medicationDosageTime.getIsTaken());
        }
    }

}
