package com.exercise.model;

import java.time.LocalDate;
import java.util.List;

public record Order(
        int id,
        String customerName,
        LocalDate orderDate,
        OrderStatus status,
        List<OrderItem> items
) {
    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }
}

