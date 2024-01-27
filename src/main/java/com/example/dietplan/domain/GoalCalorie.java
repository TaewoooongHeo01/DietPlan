package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class GoalCalorie {

    @Id
    @GeneratedValue
    @Column(name = "goalCalorie_id")
    private Long id;

    private int bmi;

    @Embedded
    private Nutri nutri;

    @OneToOne
    private Member member;
}
