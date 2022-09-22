package com.example.fraud.service.interfaces;

import com.example.fraud.entity.Client;

import java.util.List;

public interface PointCalculationService {
    Double calculateWallet();
    Double calculateTransactions();
//    Boolean checkEmailValidity(String email);
}
