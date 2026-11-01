package com.exercise.model;

import java.util.Map;

public record Student(
        int id,
        String name,
        int gradeLevel,
        Map<String, Double> grades
) {
    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        return grades.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}

