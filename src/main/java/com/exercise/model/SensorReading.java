package com.exercise.model;

import java.time.Instant;

public record SensorReading(
        String sensorId,
        String location,
        double temperature,
        double humidity,
        Instant timestamp
) {}
