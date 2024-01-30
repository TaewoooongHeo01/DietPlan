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

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    public GoalCalorie() {};

    public GoalCalorie(int bmi, Nutri nutri) {
        this.bmi = bmi;
        this.nutri = nutri;
    }

    //setter
    public void setMember(Member member) {
        this.member = member;
    }
}
