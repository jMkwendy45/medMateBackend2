package com.medMate.medMate.medications.data.models;

import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Entity
public class MedicationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication;
    @Enumerated(value = EnumType.STRING)
    private MedicationFrequency frequency;
    @Enumerated(value = EnumType.STRING)
    private MedicationRequirement medicationRequirement;
    private Integer dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime firstDoseTime;
    private Boolean isTaken;
}
