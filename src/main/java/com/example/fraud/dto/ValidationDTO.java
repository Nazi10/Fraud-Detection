package com.example.fraud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationDTO {
    private Long clientId;
    private Long transId;
    private String status;
}
