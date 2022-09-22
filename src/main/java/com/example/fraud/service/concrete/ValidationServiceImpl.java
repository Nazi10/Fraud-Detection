package com.example.fraud.service.concrete;

import com.example.fraud.dto.PointsDTO;
import com.example.fraud.dto.ValidationDTO;
import com.example.fraud.entity.Validation;
import com.example.fraud.mapper.ValidationMapper;
import com.example.fraud.repository.ClientRepo;
import com.example.fraud.repository.ValidationRepo;
import com.example.fraud.service.interfaces.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {
    private final ValidationMapper validationMapper;
    private final ValidationRepo validationRepo;
    private final ClientRepo clientRepo;
    private final PointCalculationServiceImpl calculationService;

    @Override
    public ValidationDTO addValidation(ValidationDTO validationDTO) {
        validationDTO.setStatus("Not Fraud");
        validationRepo.save(validationMapper.dtoToValidation(validationDTO));
        return validationDTO;
    }

    @Override
    public ValidationDTO updateValidation(ValidationDTO validationDTO) {
        validationRepo.save(validationMapper.dtoToValidation(validationDTO));
        return validationDTO;
    }

    @Override
    public void deleteValidation(Long validationId) {
        boolean exists = validationRepo.existsById(validationId);
        if (!exists) {
            throw new IllegalStateException(
                    "validation with id " + validationId + " does not exist");
        }
        validationRepo.deleteById(validationId);
    }

    @Override
    public List<PointsDTO> getValidations() {
        return validationMapper.pointsToDto(validationRepo.findAll());
    }

    @Override
    public List<PointsDTO> getLowRisk() {
        List<Validation> validations = validationRepo.findAll();
        List<Validation> lowRisk = new ArrayList<>();
        for (var validation : validations) {
            if (validation.getRiskPoints() <= 3.5) {
                lowRisk.add(validation);
                return validationMapper.pointsToDto(lowRisk);
            }
        }
        return null;
    }

    @Override
    public List<PointsDTO> getHighRisk() {
        List<Validation> validations = validationRepo.findAll();
        List<Validation> highRisk = new ArrayList<>();
        for (var validation : validations) {
            if (validation.getRiskPoints() <= 3.5 && validation.getRiskPoints() >= 6.5 ) {
                highRisk.add(validation);
                return validationMapper.pointsToDto(highRisk);
            }
        }
        return null;
    }

    @Override
    public List<PointsDTO> getMediumRisk() {
        List<Validation> validations = validationRepo.findAll();
        List<Validation> highRisk = new ArrayList<>();
        for (var validation : validations) {
            if (validation.getRiskPoints() >= 6.5 ) {
                highRisk.add(validation);
                return validationMapper.pointsToDto(highRisk);
            }
        }
        return null;
    }
}
