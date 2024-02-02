package com.example.dietplan.domain;

import com.example.dietplan.repository.MemberRepository;
import com.example.dietplan.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DietFoodTest {

    @Autowired
    MemberService memberService;

    @Test
    void DietFoodTest() throws Exception {
        //given
        Food food = new Food("FoodA");
        Food food2 = new Food("FoodB");

        Diet diet = new Diet("DietA");
        Diet diet2 = new Diet("DietB");

        //when
        diet.addFood(food);
        diet.addFood(food2);

        diet2.addFood(food);
        diet2.addFood(food2);

        //then
        //하나의 Food는 여러 개의 Diet에 들어갈 수 있다
        //하나의 Diet에는 여러 개의 Food가 들어갈 수 있다.
        assertThat(diet.getDietfoods().size()).isEqualTo(2);
        assertThat(diet.getDietfoods().size()).isEqualTo(diet2.getDietfoods().size());
        assertThat(food.getFoodDiets().size()).isEqualTo(2);
    }

    @Test
    void MemberDietFoodTest() throws Exception {
        //given
        Member member = new Member();
        Diet diet = new Diet();
        Food foodA = new Food();
        Food foodB = new Food();

        //when
        memberService.join(member);
        diet.addFood(foodA);
        diet.addFood(foodB);
        memberService.addDiet(member.getId(), diet);

        //then
        Member findMember = memberService.findOne(member.getId());
        Diet memberDiet = findMember.getDiets().get(0);
        List<DietFood> dietfoods = memberDiet.getDietfoods();
        assertThat(dietfoods.size()).isEqualTo(2);
    }
}
