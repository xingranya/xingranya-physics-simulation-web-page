package com.example.controller;

import com.example.service.PhysicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("mass", 5.0);
        model.addAttribute("frictionCoefficient", 0.2);
        return "ramp";
    }

    /**
     * 计算斜坡上的物体加速度
     * @param angle 斜坡角度（度）
     * @param mass 物体质量（kg）
     * @param frictionCoefficient 摩擦系数
     * @param model 用于向视图传递数据的模型对象
     * @return 返回斜坡模拟页面视图名称
     */
    @PostMapping("/calculateRamp")
    public String calculateRamp(@RequestParam double angle, 
                               @RequestParam double mass,
                               @RequestParam double frictionCoefficient,
                               Model model) {
        double acceleration = physicsService.calculateRamp(angle, mass, frictionCoefficient);
        model.addAttribute("acceleration", acceleration);
        model.addAttribute("angle", angle);
        model.addAttribute("mass", mass);
        model.addAttribute("frictionCoefficient", frictionCoefficient);
        return "ramp";
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
     * @param mass1 物体1质量（kg）
     * @param velocity1 物体1初速度（m/s）
     * @param mass2 物体2质量（kg）
     * @param velocity2 物体2初速度（m/s）
     * @param model 用于向视图传递数据的模型对象
     * @return 返回动量守恒模拟页面视图名称
     */
    @PostMapping("/calculateMomentum")
    public String calculateMomentum(@RequestParam double mass1,
                                  @RequestParam double velocity1,
                                  @RequestParam double mass2,
                                  @RequestParam double velocity2,
                                  Model model) {
        double[] finalVelocities = physicsService.calculateMomentum(mass1, velocity1, mass2, velocity2);
        model.addAttribute("mass1", mass1);
        model.addAttribute("velocity1", velocity1);
        model.addAttribute("mass2", mass2);
        model.addAttribute("velocity2", velocity2);
        model.addAttribute("finalVelocity1", finalVelocities[0]);
        model.addAttribute("finalVelocity2", finalVelocities[1]);
        return "momentum";
    }
}