package com.medMate.medMate.user.data.models;

import com.medMate.medMate.medications.data.models.Medication;
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Medication> medications;
    private String phoneNumber;
}
   