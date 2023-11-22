package com.medMate.medMate.user.data.models;

import com.medMate.medMate.user.enums.Role;
import com.medMate.medMate.medications.data.models.Medication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
