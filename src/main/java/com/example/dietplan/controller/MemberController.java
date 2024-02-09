package com.example.dietplan.controller;

import com.example.dietplan.domain.GoalCalorie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/profile/calculate")
    public String calculate() {
        return "calculate";
    }

    @PostMapping("/profile/calculate/result")
    public String calculateResult(@ModelAttribute GoalCalorie goalCalorie) {
        //member 정보 있어야 함
        log.info("testMessageBody: " + goalCalorie);
        return "redirect:/profile";
    }

    @GetMapping("/diet")
    public String createDiet() {
        return "diet";
    }
}
