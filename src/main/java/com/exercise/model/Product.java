package com.exercise.model;

import java.util.List;

public record Product(
        int id,
        String name,
        String category,
        double price,
        int stock,
        List<String> tags
) {}

