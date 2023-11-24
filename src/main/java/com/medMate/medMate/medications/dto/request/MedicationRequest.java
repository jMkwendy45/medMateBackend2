package com.medMate.medMate.medications.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.medMate.medMate.medications.enums.MedicationFrequency;
import com.medMate.medMate.medications.enums.MedicationRequirement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {
    private Integer dosage;
    private String startDate;
    private String endDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSS")
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private String firstDoseTime;
    @Enumerated(EnumType.STRING)
    private MedicationFrequency medicationFrequency;
    @Enumerated(EnumType.STRING)
    private MedicationRequirement medicationRequirement;


}
