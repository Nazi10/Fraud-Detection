package com.example.fraud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointsDTO {
    private Long clientId;
    private Double riskPoints;
    private String status;
}
