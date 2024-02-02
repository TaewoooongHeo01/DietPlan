package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    private String dietName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diet", fetch = FetchType.LAZY)
    private List<DietFood> dietfoods = new ArrayList<>();

//    private List<Bookmark> bookmarks = new ArrayList<>();
//
//    private List<Like> likes = new ArrayList<>();

    //생성자
    public Diet(String dietName) {
        this.dietName = dietName;
    }

    public Diet() {};

    //연관관계 편의 메서드

    public void addFood(Food food) {
        DietFood dietFood = new DietFood();
        this.dietfoods.add(dietFood);
        food.getFoodDiets().add(dietFood);
        dietFood.setDiet(this);
        dietFood.setFood(food);
    }

    public void addComments(Comments comments) {

    }

    //setter
    //Member 와의 연관관계 편의메서드에서 사용하기 위한 setter
    public void setMember(Member member) {
        this.member = member;
    }
}
