package com.example.fraud.service.concrete;

import com.example.fraud.entity.Client;
import com.example.fraud.entity.Transaction;
import com.example.fraud.entity.Validation;
import com.example.fraud.repository.ClientRepo;
import com.example.fraud.repository.TransactionRepo;
import com.example.fraud.repository.ValidationRepo;
import com.example.fraud.service.interfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;
    private final ValidationRepo validationRepo;

    @Override
    public Transaction addTransaction(Transaction transaction, Long clientId) {
        return transactionRepo.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        boolean exists = transactionRepo.existsById(transactionId);
        if (!exists) {
            throw new IllegalStateException(
                    "transaction with id " + transactionId + " does not exist");
        }
        transactionRepo.deleteById(transactionId);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return null;
    }
}
