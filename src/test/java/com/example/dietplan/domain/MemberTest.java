package com.example.dietplan.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @BeforeEach
    void clear() {

    }

    @Test
    void MemberGoalCalorie() throws Exception {
        //given
        Member member = new Member("memberA");
        Nutri nutri = new Nutri(1000, 500, 300, 200);
        GoalCalorie goalCalorie = new GoalCalorie(900, nutri);

        //when
        member.changeGoalCalorie(goalCalorie);
        System.out.println("member = " + member);
        System.out.println("goalCalorie.getMember() = " + goalCalorie.getMember());

        //then
        assertThat(member).isEqualTo(goalCalorie.getMember());
    }

    @Test
    void MemberDiet() throws Exception {
        //given
        Member member = new Member("memberA");
        Diet diet = new Diet("dietA");
        Diet diet2 = new Diet("dietB");

        //when
        member.addDiet(diet);
        member.addDiet(diet2);

        //then
        assertThat(member).isEqualTo(diet.getMember());
        assertThat(member).isEqualTo(diet2.getMember());
    }
}