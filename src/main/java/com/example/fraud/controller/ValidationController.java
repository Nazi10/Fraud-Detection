package com.example.fraud.controller;

import com.example.fraud.dto.PointsDTO;
import com.example.fraud.dto.ValidationDTO;
import com.example.fraud.service.interfaces.PointCalculationService;
import com.example.fraud.service.interfaces.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "validation")
public class ValidationController {

    private final ValidationService validationService;
    private final PointCalculationService calculationService;

    @PostMapping("/addValidation")
    public ResponseEntity<ValidationDTO> addValidation(@RequestBody ValidationDTO validationDTO) {
        return ResponseEntity.ok(validationService.addValidation(validationDTO));
    }

    @GetMapping("/allValidations")
    public ResponseEntity<List<PointsDTO>> getAllValidations() {
        return ResponseEntity.ok(validationService.getValidations());
    }

    @PatchMapping("/updateValidation")
    public ResponseEntity<ValidationDTO> updateValidation(@RequestBody ValidationDTO validationDTO) {
        return ResponseEntity.ok(validationService.updateValidation(validationDTO));
    }

    @DeleteMapping("/deleteValidation/{validationId}")
    public void deleteClients(@PathVariable Long validationId) {
        validationService.deleteValidation(validationId);
    }
    @GetMapping("/lowRisk")
    public ResponseEntity<List<PointsDTO>> getLowRisk() {
        return ResponseEntity.ok(validationService.getLowRisk());
    }
    @PatchMapping("/calculateTrans")
    public ResponseEntity<Double> calculateTrans() {
        return ResponseEntity.ok(calculationService.calculateTransactions());
    }
    @PatchMapping("/calculateWallet")
    public ResponseEntity<Double> calculateWallet() {
        return ResponseEntity.ok(calculationService.calculateWallet());
    }

}
