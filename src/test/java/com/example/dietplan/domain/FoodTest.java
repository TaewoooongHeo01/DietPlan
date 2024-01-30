package com.example.dietplan.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodTest {

    @Test
    @DisplayName("음식(게시글)에 comment 달기")
    void addComentOnFood() throws Exception {
        //given
        Member member = new Member("MemberA");
        Food food = new Food("foodA");
        Comments comments = new Comments("foodA에 대한 Comment", member);
        Comments comments1 = new Comments("foodA에 대한 두번째 Comment", member);
        food.addComments(comments);
        food.addComments(comments1);

        //when
        String memberComment = member.getComments().get(0).getComment();
        String secondComment = food.getComments().get(1).getComment();

        //then
        assertThat(member.getComments().size()).isEqualTo(2);
        assertThat(secondComment).isEqualTo("foodA에 대한 두번째 Comment");
        assertThat(memberComment).isEqualTo("foodA에 대한 Comment");
    }
}