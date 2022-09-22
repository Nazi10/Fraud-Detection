package com.example.fraud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "client")
    private List<Validation> validations = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions = new ArrayList<>();
}
