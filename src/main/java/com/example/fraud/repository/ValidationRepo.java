package com.example.fraud.repository;

import com.example.fraud.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepo extends JpaRepository<Validation, Long> {
    Validation findValidationByClientClientId(Long clientId);
}
