package com.example.dietplan.service;

import com.example.dietplan.domain.Comments;
import com.example.dietplan.domain.Food;
import com.example.dietplan.domain.Member;
import com.example.dietplan.domain.Nutri;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class FoodCommentsTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FoodService foodService;

    @Test
    void CommentTest() throws Exception {
        //given
        Member member = new Member();
        Food food = new Food();
        Comments commentsA = new Comments("commentsA", member);
        Comments commentsB = new Comments("commentsB", member);
        Nutri nutri = new Nutri();

        //when
        memberService.join(member);
        foodService.saveFood(food, nutri);
        memberService.addComments(food.getId(), commentsA);
        memberService.addComments(food.getId(), commentsB);

        //then
        List<Comments> comments = foodService.findComments(food.getId());
        Assertions.assertThat(comments.size()).isEqualTo(2);
        System.out.println(comments.get(1).getComment());
    }
}
