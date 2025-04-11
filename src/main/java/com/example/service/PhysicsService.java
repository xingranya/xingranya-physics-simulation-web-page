package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PhysicsService {

    public double calculateLever(double leverLength, double force, double angle) {
        // 计算有效力臂（考虑力的角度）
        double effectiveLeverLength = leverLength * Math.sin(Math.toRadians(angle));
        // 计算力矩
        return force * effectiveLeverLength;
    }

    public double calculateFreefall(double height) {
        // 考虑空气阻力的更精确模型
        double terminalVelocity = 53; // 典型人体终端速度(m/s)，可根据需要调整
        double time = 0;
        double velocity = 0;
        double distance = 0;
        double deltaT = 0.01; // 时间步长
        
        while (distance < height) {
            // 空气阻力与速度平方成正比
            double dragForce = 0.5 * 1.2 * 0.04 * velocity * velocity; // 空气密度1.2kg/m³，横截面积0.04m²
            double netForce = 9.80665 - dragForce;
            double acceleration = netForce;
            
            velocity += acceleration * deltaT;
            distance += velocity * deltaT;
            time += deltaT;
            
            if (velocity >= terminalVelocity) {
                velocity = terminalVelocity;
                // 终端速度阶段
                time += (height - distance) / terminalVelocity;
                break;
            }
        }
        
        return time;
    }

    public double calculateRamp(double angle, double mass, double frictionCoefficient) {
        double radians = Math.toRadians(angle);
        double normalForce = mass * 9.80665 * Math.cos(radians); // 使用标准重力加速度
        double frictionForce = frictionCoefficient * normalForce;
        double gravityComponent = mass * 9.80665 * Math.sin(radians);
        
        // 考虑静摩擦力和动摩擦力的区别
        if (gravityComponent <= frictionForce) {
            return 0; // 物体不会滑动
        }
        
        // 更精确的加速度计算
        return (gravityComponent - frictionForce) / mass;
    }
}