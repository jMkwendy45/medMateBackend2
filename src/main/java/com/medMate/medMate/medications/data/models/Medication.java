package com.medMate.medMate.medications.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String medicationName;
    private String medicationForm;
    private String medicationPurpose;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private MedicationSchedule medicationSchedule;

}
