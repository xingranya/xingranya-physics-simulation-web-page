package com.example.controller;

import com.example.service.PhysicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhysicsController {

    @Autowired
    private PhysicsService physicsService;

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/ramp")
    public String showRampPage(Model model) {
        model.addAttribute("angle", 30.0);
        model.addAttribute("mass", 5.0);
        model.addAttribute("frictionCoefficient", 0.2);
        return "ramp";
    }

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

    @GetMapping("/lever")
    public String showLeverPage(Model model) {
        model.addAttribute("leverLength", 2.0);
        model.addAttribute("force", 50.0);
        model.addAttribute("angle", 30.0);
        return "lever";
    }

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

    @GetMapping("/freefall")
    public String showFreefallPage(Model model) {
        model.addAttribute("height", 10.0);
        return "freefall";
    }

    @PostMapping("/calculateFreefall")
    public String calculateFreefall(@RequestParam double height,
                                   Model model) {
        double velocity = physicsService.calculateFreefall(height);
        model.addAttribute("velocity", velocity);
        model.addAttribute("height", height);
        return "freefall";
    }
}