package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "goalCalorie_id")
    private GoalCalorie goalCalorie;

    @OneToMany(mappedBy = "member")
    private List<Diet> diets = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comments> comments = new ArrayList<>();

    //private List<Bookmark> bookmarks = new ArrayList<>();
    //private List<Like> likes = new ArrayList<>();

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }

    //연관관계 편의 메서드
    //Member 가 주인인 단방향 매핑이므로 goalCalorie 에서는 Member 를 참조할 수 없음
    public void changeGoalCalorie(GoalCalorie goalCalorie) {
        this.goalCalorie = goalCalorie;
        goalCalorie.setMember(this);
    }

    //Diet 가 "다"로써 Member 와의 연관관계에서 주인이지만,
    //Member 에서 Diet 를 지정하는 일이 더 많으므로 Member 에 편의메서드 생성
    public void addDiet(Diet diet) {
        this.diets.add(diet);
        diet.setMember(this);
    }
}
