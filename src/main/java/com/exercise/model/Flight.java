package com.exercise.model;

import java.time.LocalDateTime;

public record Flight(
        String flightNumber,
        String origin,
        String destination,
        LocalDateTime departureTime,
        int durationMinutes,
        double price,
        int availableSeats
) {}
