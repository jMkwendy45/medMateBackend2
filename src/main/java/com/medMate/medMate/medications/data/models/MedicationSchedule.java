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
import java.util.List;

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
    private Integer dosage;
    private String startDate;
    private String endDate;
    @CollectionTable(name = "dosage_times", joinColumns = @JoinColumn(name = "medication_schedule_id"))
    @Column(name = "dosage_time")
    @OneToMany
    private List<MedicationDosageTime> dosageTimes;

}
