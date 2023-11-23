package com.medMate.medMate.auth.data.repositories;

import com.medMate.medMate.auth.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
}
