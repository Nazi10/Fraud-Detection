package com.example.fraud.service.interfaces;

import com.example.fraud.dto.PointsDTO;
import com.example.fraud.dto.ValidationDTO;

import java.util.List;

public interface ValidationService {
 ValidationDTO addValidation(ValidationDTO validationDTO);
 ValidationDTO updateValidation(ValidationDTO validationDTO);
 void deleteValidation(Long validationId);
 List<PointsDTO> getValidations();
 List<PointsDTO> getLowRisk();
 List<PointsDTO> getHighRisk();
 List<PointsDTO> getMediumRisk();

}
