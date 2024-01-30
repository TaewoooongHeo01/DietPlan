package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Food {

    @Id
    @GeneratedValue
    @Column(name = "food_id")
    private Long id;

    private String foodName;

    @Embedded
    private Nutri nutri;

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private List<DietFood> foodDiets = new ArrayList<>();

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private List<Comments> comments = new ArrayList<>();

    public void addComments(Comments comments) {
        this.comments.add(comments);
        comments.setFood(this);
    }

    //생성자
    public Food() {};

    public Food(String foodName) {
        this.foodName = foodName;
    }
}
