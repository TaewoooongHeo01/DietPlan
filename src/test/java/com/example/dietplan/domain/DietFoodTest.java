package com.example.dietplan.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DietFoodTest {

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
}
