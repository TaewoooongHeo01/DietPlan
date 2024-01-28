package com.example.dietplan.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DietTest {


    @Test
    @DisplayName("post 댓글기능")
    void DietComments() throws Exception {
        //given
        Diet diet = new Diet("DietA");
        Diet diet2 = new Diet("DietB");
        Member member = new Member("MemberA");
        Comments comments = new Comments("안녕하세요", member);
        Comments comments1 = new Comments("comment2", member);

        //when
        diet.addComments(comments);
        diet.addComments(comments1);

        diet2.addComments(comments);
        Member findMember = comments.getMember();

        //then
        assertThat(diet.getComments().size()).isEqualTo(2);
        assertThat(findMember.getUsername()).isEqualTo("MemberA");
    }
}
