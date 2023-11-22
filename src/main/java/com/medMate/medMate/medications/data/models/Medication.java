package com.medMate.medMate.medications.data.models;

import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.models.User;
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
    @ManyToOne
    @JoinColumn(name = "patient_profile_id")
    private PatientProfile patientProfile;

}
