package com.example.fraud.controller;

import com.example.fraud.entity.Transaction;
import com.example.fraud.service.interfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/addTrans/{clientId}")
    public ResponseEntity<Transaction> addTrans(@RequestBody Transaction transaction, @PathVariable Long clientId) {
        return ResponseEntity.ok(transactionService.addTransaction(transaction, clientId));
    }

    @GetMapping("/allTransactions")
    public ResponseEntity<List<Transaction>> getAllValidations() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @PatchMapping("/updateTrans")
    public ResponseEntity<Transaction> updateValidation(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.updateTransaction(transaction));
    }

    @DeleteMapping("/deleteTrans/{transactionId}")
    public void deleteClients(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
    }
}
