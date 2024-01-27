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


}
