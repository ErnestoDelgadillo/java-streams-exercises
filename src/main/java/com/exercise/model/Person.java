package com.exercise.model;

import java.util.List;

public record Person(
        int id,
        String name,
        int age,
        Gender gender,
        String email,
        List<String> hobbies
) {}

