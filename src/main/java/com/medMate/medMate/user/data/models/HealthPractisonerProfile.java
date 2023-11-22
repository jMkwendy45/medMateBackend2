package com.medMate.medMate.user.data.models;

import com.medMate.medMate.medications.data.models.Medication;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class HealthPractisonerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialtiy;
    @ManyToMany
    @JoinTable(
            name = "health_practitioner_patients",
            joinColumns = @JoinColumn(name = "health_practitioner_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<PatientProfile> patients;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<HealthPractionersRequest> doctorRequests;
}
