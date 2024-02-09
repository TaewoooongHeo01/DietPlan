package com.example.dietplan.controller;

import com.example.dietplan.domain.GoalCalorie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{testPage}")
    public String test(@PathVariable("testPage") int testPage) {
        log.info("test page: " + testPage);
        return "test";
    }

    @PostMapping("/result")
    public String testResult(@ModelAttribute GoalCalorie goalCalorie) {
        //유저 저장 로직
        return "result";
    }
}
