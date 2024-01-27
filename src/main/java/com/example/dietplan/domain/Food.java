package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Food {

    @Id
    @GeneratedValue
    private Long id;

    private String foodName;

    @Embedded
    private Nutri nutri;

    @OneToMany(mappedBy = "food")
    private List<DietFood> dietfoods = new ArrayList<>();
}
