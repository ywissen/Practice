package com.bank.springbankingtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long accountNumber;

    @NonNull
    private String currency;

    @NonNull
    private String instructionType;

    @NonNull
    private Double amount;

    @NonNull
    private String bank;

    @NonNull
    private String branch;
}
