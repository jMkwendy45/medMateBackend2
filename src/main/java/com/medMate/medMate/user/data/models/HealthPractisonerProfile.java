package com.medMate.medMate.user.data.models;

import com.medMate.medMate.auth.dto.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HealthPractisonerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialtiy;
    @OneToOne
    private User user;
}
