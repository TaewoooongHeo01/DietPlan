package com.example.dietplan.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Nutri {

    private int totalCalorie;

    private int carbohydrate;

    private int protein;

    private int fat;

    public Nutri() {};

    public Nutri(int totalCalorie, int carbohydrate, int protein, int fat) {
        this.totalCalorie = totalCalorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }
}
