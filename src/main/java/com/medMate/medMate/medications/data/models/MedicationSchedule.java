package com.medMate.medMate.medications.data.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String startDate;
    private String endDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSS")
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private String firstDoseTime;
    private Boolean isTaken;
}
