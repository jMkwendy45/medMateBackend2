package com.medMate.medMate.user.data.repositories;

import com.medMate.medMate.user.data.models.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProfileRepository  extends JpaRepository<PatientProfile,Long> {
}
