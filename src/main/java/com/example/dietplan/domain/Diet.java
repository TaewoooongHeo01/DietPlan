package com.example.dietplan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    private String dietName;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diet")
    private List<DietFood> dietfoods = new ArrayList<>();

    @OneToMany(mappedBy = "diet")
    private List<Comments> comments = new ArrayList<>();

    //private List<Bookmark> bookmarks = new ArrayList<>();

    //private List<Like> likes = new ArrayList<>();
}
