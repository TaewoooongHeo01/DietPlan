package com.example.dietplan.domain;

import com.example.dietplan.domain.calcorieEnum.ActivityLevel;
import com.example.dietplan.domain.calcorieEnum.Gender;
import com.example.dietplan.domain.calcorieEnum.Purpose;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class GoalCalorie {

    @Id
    @GeneratedValue
    @Column(name = "goalCalorie_id")
    private Long id;

    private double bmi;

    private double maintenanceCalories;

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

    //business
    //harris-benedict calculate
    public Nutri calculateCalorie() {
        Nutri nutri = new Nutri();
        Gender gender = this.member.getGender();
        int age = this.member.getAge();
        int weight = this.member.getWeight();
        int height = this.member.getHeight();
        ActivityLevel activityLevel = this.member.getActivityLevel();
        Purpose purpose = this.member.getPurpose();

        //bmi 계산
        if (gender == Gender.MALE) {
            this.bmi = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        } else if (gender == Gender.FEMALE) {
            this.bmi = 665 + (9.7 * weight) + (1.7 * height) - (4.7 * age);
        }

        switch (activityLevel) {
            case LESS -> {
                this.maintenanceCalories = this.bmi * 1.2;
            }
            case MANY -> {
                this.maintenanceCalories = this.bmi * 1.375;
            }
            case NORMAL -> {
                this.maintenanceCalories = this.bmi * 1.55;
            }
            case VERYLESS -> {
                this.maintenanceCalories = this.bmi * 1.725;
            }
            case VERYMANY -> {
                this.maintenanceCalories = this.bmi * 1.9;
            }
        }

        double goal = 0;
        double needCalorie = this.maintenanceCalories * 0.2;
        switch (purpose) {
            case GAIN -> {
                goal = this.maintenanceCalories + needCalorie;
            }
            case LOSS -> {
                goal = this.maintenanceCalories - needCalorie;
            }
            case MAINTAIN -> {
                goal = this.maintenanceCalories;
            }
        }
        this.nutri = nutri;

        this.nutri.setTotalCalorie(goal);
        this.nutri.setCarbohydrate(goal*0.5);
        this.nutri.setProtein(goal*0.3);
        this.nutri.setFat(goal*0.2);
        return nutri;
    }
}
