package com.medMate.medMate.user.data.repositories;

import com.medMate.medMate.user.data.models.HealthPractionersRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthPractionerRequestRepository  extends JpaRepository<HealthPractionersRequest,Long> {
}
