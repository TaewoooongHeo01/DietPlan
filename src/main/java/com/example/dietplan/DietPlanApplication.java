package com.example.dietplan;

import com.example.dietplan.domain.Member;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DietPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DietPlanApplication.class, args);

    }

}
