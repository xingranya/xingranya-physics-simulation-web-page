package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PhysicsService {

    public double calculateLever(double leverLength, double force) {
        return force * leverLength;
    }

    public double calculateFreefall(double height) {
        return Math.sqrt(2 * height / 9.8);
    }

    public double calculateRamp(double angle, double mass, double frictionCoefficient) {
        double radians = Math.toRadians(angle);
        return (mass * 9.8 * Math.sin(radians)) - (frictionCoefficient * mass * 9.8 * Math.cos(radians));
    }
}