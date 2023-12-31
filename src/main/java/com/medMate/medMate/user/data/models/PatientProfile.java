package com.medMate.medMate.user.data.models;

import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class PatientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Medication> medications;
    @OneToOne
    private User user;
    @OneToMany
    List<HealthPractisonerProfile>healthPractisoner;
    private Long doctorId;
}
   