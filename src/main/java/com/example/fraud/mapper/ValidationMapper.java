package com.example.fraud.mapper;

import com.example.fraud.dto.PointsDTO;
import com.example.fraud.dto.ValidationDTO;
import com.example.fraud.entity.Validation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ValidationMapper {
    @Mapping(source = "client.clientId", target = "clientId")
    @Mapping(source = "transaction.transId", target = "transId")
    ValidationDTO validationToDto(Validation validation);
    @Mapping(source = "clientId", target = "client.clientId")
    @Mapping(source = "transId", target = "transaction.transId")
    Validation dtoToValidation(ValidationDTO validationDTO);
    List<ValidationDTO> validationToDtoList(List<Validation> validations);
    @Mapping(source = "client.clientId", target = "clientId")
    List<PointsDTO> pointsToDto(List<Validation> validations);
    @Mapping(source = "clientId", target = "client.clientId")
    Validation dtoToPoints(PointsDTO pointsDTO);

}
