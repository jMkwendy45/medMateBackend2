package com.medMate.medMate.user.data.repositories;

import com.medMate.medMate.user.data.models.PatientProfile;
import com.medMate.medMate.user.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientProfileRepository  extends JpaRepository<PatientProfile,Long> {
    Optional<PatientProfile> findPatientProfileByUser(User user);
}
