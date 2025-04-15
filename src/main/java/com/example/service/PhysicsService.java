package com.example.service;

import org.springframework.stereotype.Service;

/**
 * 物理计算服务类
 * 提供各种物理现象的计算方法
 * 包括杠杆、自由落体和斜坡等物理模型的计算
 */
@Service
public class PhysicsService {

    /**
     * 计算杠杆的扭矩
     * @param leverLength 杠杆长度（m）
     * @param force 作用力（N）
     * @param angle 作用力与杠杆的夹角（度）
     * @return 返回计算得到的扭矩值（N·m）
     */
    public double calculateLever(double leverLength, double force, double angle) {
        // 计算有效力臂（考虑力的角度）
        double effectiveLeverLength = leverLength * Math.sin(Math.toRadians(angle));
        // 计算力矩
        return force * effectiveLeverLength;
    }

    /**
     * 计算自由落体的下落时间
     * 使用考虑空气阻力的精确模型进行计算
     * @param height 下落高度（m）
     * @return 返回下落所需的时间（秒）
     */
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

    /**
     * 计算斜坡上物体的加速度
     * 考虑摩擦力和重力的影响
     * @param angle 斜坡角度（度）
     * @param mass 物体质量（kg）
     * @param frictionCoefficient 摩擦系数
     * @return 返回物体的加速度（m/s²）
     */
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

    /**
     * 计算完全弹性碰撞后两个物体的速度
     * 基于动量守恒和能量守恒定律
     * @param mass1 物体1的质量（kg）
     * @param velocity1 物体1的初速度（m/s）
     * @param mass2 物体2的质量（kg）
     * @param velocity2 物体2的初速度（m/s）
     * @return 返回包含两个物体碰撞后速度的数组 [v1', v2']
     */
    public double[] calculateMomentum(double mass1, double velocity1, double mass2, double velocity2) {
        // 基于完全弹性碰撞的公式计算
        double v1Final = ((mass1 - mass2) * velocity1 + 2 * mass2 * velocity2) / (mass1 + mass2);
        double v2Final = ((mass2 - mass1) * velocity2 + 2 * mass1 * velocity1) / (mass1 + mass2);
        
        return new double[] {v1Final, v2Final};
    }

    /**
     * 计算一维碰撞后的速度
     * @param m1 第一个物体的质量
     * @param v1 第一个物体的初速度
     * @param m2 第二个物体的质量
     * @param v2 第二个物体的初速度
     * @param e 恢复系数 (0-1)
     * @return 包含两个物体碰撞后速度的数组 [v1', v2']
     */
    public double[] calculateCollision(double m1, double v1, double m2, double v2, double e) {
        // 计算碰撞后的速度
        double v1Prime, v2Prime;
        
        if (e == 1) { // 弹性碰撞
            v1Prime = ((m1 - m2) * v1 + 2 * m2 * v2) / (m1 + m2);
            v2Prime = (2 * m1 * v1 + (m2 - m1) * v2) / (m1 + m2);
        } else if (e == 0) { // 完全非弹性碰撞
            double vCommon = (m1 * v1 + m2 * v2) / (m1 + m2);
            v1Prime = vCommon;
            v2Prime = vCommon;
        } else { // 非弹性碰撞
            v1Prime = ((m1 - e * m2) * v1 + (1 + e) * m2 * v2) / (m1 + m2);
            v2Prime = ((1 + e) * m1 * v1 + (m2 - e * m1) * v2) / (m1 + m2);
        }
        
        return new double[]{v1Prime, v2Prime};
    }

    /**
     * 计算系统的总动量
     * @param m1 第一个物体的质量
     * @param v1 第一个物体的速度
     * @param m2 第二个物体的质量
     * @param v2 第二个物体的速度
     * @return 系统的总动量
     */
    public double calculateTotalMomentum(double m1, double v1, double m2, double v2) {
        return m1 * v1 + m2 * v2;
    }

    /**
     * 计算系统的总动能
     * @param m1 第一个物体的质量
     * @param v1 第一个物体的速度
     * @param m2 第二个物体的质量
     * @param v2 第二个物体的速度
     * @return 系统的总动能
     */
    public double calculateTotalKineticEnergy(double m1, double v1, double m2, double v2) {
        return 0.5 * (m1 * v1 * v1 + m2 * v2 * v2);
    }
}