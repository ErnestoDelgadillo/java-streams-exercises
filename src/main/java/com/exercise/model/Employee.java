package com.exercise.model;

import java.util.List;

public record Employee(
        int id,
        String name,
        String department,
        double salary,
        int joiningYear,
        List<String> skills
) {}

