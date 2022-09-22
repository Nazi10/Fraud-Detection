package com.example.fraud.service.interfaces;

import com.example.fraud.entity.Client;
import com.example.fraud.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction, Long clientId);

    void deleteTransaction(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long transactionId);
}
