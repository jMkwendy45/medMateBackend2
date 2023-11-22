package com.medMate.medMate.user.data.models;

import com.medMate.medMate.user.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HealthPractionersRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private HealthPractisonerProfile doctor;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
