package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    //생성자
    public Comments(String comment, Member member) {
        this.comment = comment;
        this.member = member;
        member.getComments().add(this);
    }

    public Comments() {};

    //Member 와의 연관관계 편의 메서드에서 사용하기 위한 setter
    public void setMember(Member member) {
        this.member = member;
    }

    //Diet 와의 연관관계 편의 메서드에서 사용하기 위한 setter
    public void setDiet(Diet diet) {
        this.diet = diet;
    }
}
