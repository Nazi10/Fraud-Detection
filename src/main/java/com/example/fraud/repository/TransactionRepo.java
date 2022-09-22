package com.example.fraud.repository;

import com.example.fraud.entity.Transaction;
import com.example.fraud.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
