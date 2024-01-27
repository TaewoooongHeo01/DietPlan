package com.example.dietplan.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Nutri {

    private int totalCalorie;

    private int carbohydrate;

    private int protein;

    private int fat;
}
