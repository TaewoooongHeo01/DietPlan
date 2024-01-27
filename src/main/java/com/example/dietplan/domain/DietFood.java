package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class DietFood {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
