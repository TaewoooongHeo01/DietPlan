package com.example.dietplan.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Nutri {

    private double totalCalorie;

    private double carbohydrate;

    private double protein;

    private double fat;
}
