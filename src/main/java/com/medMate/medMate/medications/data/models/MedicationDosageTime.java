package com.medMate.medMate.medications.data.models;

import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class MedicationDosageTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String dosageTime;
    private String  amountOfPill;
    private Boolean isTaken;
    @Enumerated(value = EnumType.STRING)
    private MedicationRequirement medicationRequirement;
}
