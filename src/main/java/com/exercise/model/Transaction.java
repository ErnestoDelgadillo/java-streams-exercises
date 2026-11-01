package com.exercise.model;

import java.time.LocalDate;

public record Transaction(
        String id,
        LocalDate date,
        double amount,
        TransactionType type,
        String currency
) {}

