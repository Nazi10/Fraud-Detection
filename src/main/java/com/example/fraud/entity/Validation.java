package com.example.fraud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long validationId;
    private Double riskPoints;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Transaction transaction;
}
