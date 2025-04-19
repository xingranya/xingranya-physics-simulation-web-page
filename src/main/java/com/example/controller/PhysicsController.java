package com.example.controller;

import com.example.service.PhysicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 物理模拟控制器类
 * 负责处理所有与物理模拟相关的HTTP请求
 * 包括斜坡、杠杆和自由落体等物理现象的模拟计算
 */
@Controller
public class PhysicsController {

    @Autowired
    private PhysicsService physicsService;

    /**
     * 显示主页
     * @return 返回主页视图名称
     */
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    /**
     * 显示斜坡实验说明页面
     * @return 返回斜坡实验说明页面
     */
    @GetMapping("/ramp-intro")
    public String showRampIntroPage() {
        return "ramp-intro";
    }

    /**
     * 显示斜坡模拟页面
     * @param model 用于向视图传递数据的模型对象
     * @return 返回斜坡模拟页面视图名称
     */
    @GetMapping("/ramp")
    public String showRampPage(Model model) {
        model.addAttribute("angle", 30.0);
        model.addAttribute("mass", 1.0);
        model.addAttribute("friction", 0.1);
        return "ramp";
    }

    /**
     * 计算斜坡上的物体加速度
     * @param angle 斜坡角度（度）
     * @param mass 物体质量（kg）
     * @param friction 摩擦系数
     * @param model 用于向视图传递数据的模型对象
     * @return 返回斜坡模拟页面视图名称
     */
    @PostMapping("/calculateRamp")
    public String calculateRamp(@RequestParam double angle, 
                               @RequestParam double mass,
                               @RequestParam(name = "friction") double frictionCoefficient,
                               Model model) {
        double acceleration = physicsService.calculateRamp(angle, mass, frictionCoefficient);
        
        double gravityParallel = mass * 9.8 * Math.sin(Math.toRadians(angle));
        double gravityPerpendicular = mass * 9.8 * Math.cos(Math.toRadians(angle));
        double normalForce = gravityPerpendicular;
        double frictionForce = frictionCoefficient * normalForce;
        
        model.addAttribute("acceleration", acceleration);
        model.addAttribute("angle", angle);
        model.addAttribute("mass", mass);
        model.addAttribute("friction", frictionCoefficient);
        model.addAttribute("gravityParallel", gravityParallel);
        model.addAttribute("normalForce", normalForce);
        model.addAttribute("frictionForce", frictionForce);
        
        return "ramp";
    }

    /**
     * 计算斜坡上的物体物理量（AJAX请求）
     * @param angle 斜坡角度（度）
     * @param mass 物体质量（kg）
     * @param friction 摩擦系数
     * @return 返回包含物理量计算结果的JSON对象
     */
    @PostMapping("/calculateRampAjax")
    @ResponseBody
    public Map<String, Object> calculateRampAjax(
            @RequestParam double angle, 
            @RequestParam double mass,
            @RequestParam double friction) {
        
        double g = 9.8;
        double radians = Math.toRadians(angle);
        double gravityParallel = mass * g * Math.sin(radians);
        double gravityPerpendicular = mass * g * Math.cos(radians);
        double normalForce = gravityPerpendicular;
        double frictionForce = friction * normalForce;
        double netForce = gravityParallel - frictionForce;
        double acceleration = netForce / mass;
        
        boolean isStatic = acceleration <= 0;
        
        double maxStaticAngle = Math.toDegrees(Math.atan(friction));
        
        Map<String, Object> result = new HashMap<>();
        result.put("acceleration", acceleration);
        result.put("gravityParallel", gravityParallel);
        result.put("gravityPerpendicular", gravityPerpendicular);
        result.put("normalForce", normalForce);
        result.put("frictionForce", frictionForce);
        result.put("isStatic", isStatic);
        result.put("maxStaticAngle", maxStaticAngle);
        
        if (!isStatic) {
            double timeToBottom = Math.sqrt(2 * mass * 9.8 * Math.sin(radians) / netForce);
            double velocityAtBottom = acceleration * timeToBottom;
            result.put("timeToBottom", timeToBottom);
            result.put("velocityAtBottom", velocityAtBottom);
        }
        
        return result;
    }

    /**
     * 显示杠杆实验说明页面
     * @return 返回杠杆实验说明页面
     */
    @GetMapping("/lever-intro")
    public String showLeverIntroPage() {
        return "lever-intro";
    }

    /**
     * 显示杠杆模拟页面
     * @param model 用于向视图传递数据的模型对象
     * @return 返回杠杆模拟页面视图名称
     */
    @GetMapping("/lever")
    public String showLeverPage(Model model) {
        model.addAttribute("leverLength", 2.0);
        model.addAttribute("force", 50.0);
        model.addAttribute("angle", 30.0);
        return "lever";
    }

    /**
     * 计算杠杆的扭矩
     * @param leverLength 杠杆长度（m）
     * @param force 作用力（N）
     * @param angle 作用力与杠杆的夹角（度）
     * @param model 用于向视图传递数据的模型对象
     * @return 返回杠杆模拟页面视图名称
     */
    @PostMapping("/calculateLever")
    public String calculateLever(@RequestParam double leverLength,
                               @RequestParam double force,
                               @RequestParam double angle,
                               Model model) {
        double torque = physicsService.calculateLever(leverLength, force, angle);
        model.addAttribute("torque", torque);
        model.addAttribute("leverLength", leverLength);
        model.addAttribute("force", force);
        model.addAttribute("angle", angle);
        return "lever";
    }

    /**
     * 显示自由落体实验说明页面
     * @return 返回自由落体实验说明页面
     */
    @GetMapping("/freefall-intro")
    public String showFreefallIntroPage() {
        return "freefall-intro";
    }

    /**
     * 显示自由落体模拟页面
     * @param model 用于向视图传递数据的模型对象
     * @return 返回自由落体模拟页面视图名称
     */
    @GetMapping("/freefall")
    public String showFreefallPage(Model model) {
        model.addAttribute("height", 10.0);
        return "freefall";
    }

    /**
     * 计算自由落体的末速度
     * @param height 下落高度（m）
     * @param model 用于向视图传递数据的模型对象
     * @return 返回自由落体模拟页面视图名称
     */
    @PostMapping("/calculateFreefall")
    public String calculateFreefall(@RequestParam double height,
                                   Model model) {
        double velocity = physicsService.calculateFreefall(height);
        model.addAttribute("velocity", velocity);
        model.addAttribute("height", height);
        return "freefall";
    }

    /**
     * 显示动量守恒实验说明页面
     * @return 返回动量守恒实验说明页面
     */
    @GetMapping("/momentum-intro")
    public String showMomentumIntroPage() {
        return "momentum-intro";
    }

    /**
     * 显示动量守恒模拟页面
     * @param model 用于向视图传递数据的模型对象
     * @return 返回动量守恒模拟页面视图名称
     */
    @GetMapping("/momentum")
    public String showMomentumPage(Model model) {
        model.addAttribute("mass1", 1.0);
        model.addAttribute("velocity1", 5.0);
        model.addAttribute("mass2", 1.0);
        model.addAttribute("velocity2", -5.0);
        return "momentum";
    }

    /**
     * 计算碰撞后的速度
     * @param m1 物体1质量（kg）
     * @param v1 物体1初速度（m/s）
     * @param m2 物体2质量（kg）
     * @param v2 物体2初速度（m/s）
     * @param e 碰撞系数（0-1）
     * @return 返回动量守恒模拟页面视图名称
     */
    @PostMapping("/calculateMomentum")
    @ResponseBody
    public Map<String, Object> calculateMomentum(
            @RequestParam double m1,
            @RequestParam double v1,
            @RequestParam double m2,
            @RequestParam double v2,
            @RequestParam double e) {
        
        // 计算碰撞后的速度
        double[] finalVelocities = physicsService.calculateCollision(m1, v1, m2, v2, e);
        double v1Prime = finalVelocities[0];
        double v2Prime = finalVelocities[1];
        
        // 计算碰撞前后的动量和动能
        double initialMomentum = physicsService.calculateTotalMomentum(m1, v1, m2, v2);
        double finalMomentum = physicsService.calculateTotalMomentum(m1, v1Prime, m2, v2Prime);
        double initialEnergy = physicsService.calculateTotalKineticEnergy(m1, v1, m2, v2);
        double finalEnergy = physicsService.calculateTotalKineticEnergy(m1, v1Prime, m2, v2Prime);
        
        // 检查动量守恒（允许小的误差）
        boolean isMomentumConserved = Math.abs(initialMomentum - finalMomentum) < 0.0001;
        // 检查能量守恒（仅对弹性碰撞）
        boolean isEnergyConserved = e == 1 && Math.abs(initialEnergy - finalEnergy) < 0.0001;
        
        Map<String, Object> result = new HashMap<>();
        result.put("v1Prime", v1Prime);
        result.put("v2Prime", v2Prime);
        result.put("initialMomentum", initialMomentum);
        result.put("finalMomentum", finalMomentum);
        result.put("initialEnergy", initialEnergy);
        result.put("finalEnergy", finalEnergy);
        result.put("isMomentumConserved", isMomentumConserved);
        result.put("isEnergyConserved", isEnergyConserved);
        
        return result;
    }

    /**
     * 显示简谐运动实验说明页面
     * @return 返回简谐运动实验说明页面
     */
    @GetMapping("/shm-intro")
    public String showSHMIntroPage() {
        return "shm-intro";
    }

    /**
     * 显示简谐运动模拟页面
     * @param model 用于向视图传递数据的模型对象
     * @return 返回简谐运动模拟页面视图名称
     */
    @GetMapping("/shm")
    public String showSHMPage(Model model) {
        model.addAttribute("springConstant", 10.0);
        model.addAttribute("mass", 1.0);
        model.addAttribute("amplitude", 0.2);
        model.addAttribute("damping", 0.0);
        return "shm";
    }
}