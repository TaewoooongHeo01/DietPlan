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
}
