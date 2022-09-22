package com.example.fraud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transId;
    private Long amount;

    @OneToMany(mappedBy = "transaction")
    private List<Validation> validations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Client client;


}
