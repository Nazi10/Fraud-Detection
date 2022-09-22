package com.example.fraud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long clientId;
    private String first;
    private String last;
    private Integer clientAge;
    private String gender;
    private String street;
    private String ipAddress;
    private String password;
    private String number;
    private String email;
    private String educationLevel;
    private String maritalStatus;
    private String incomeCategory;
    private Long deviceId;
    private Long bankHash;
    private Integer monthsInactive;
    private Double creditLimit;
    private String cardType;
}
