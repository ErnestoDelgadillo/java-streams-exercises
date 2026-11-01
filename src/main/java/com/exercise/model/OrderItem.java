package com.exercise.model;

public record OrderItem(
        Product product,
        int quantity,
        double unitPrice
) {
    public double getTotal() {
        return quantity * unitPrice;
    }
}

