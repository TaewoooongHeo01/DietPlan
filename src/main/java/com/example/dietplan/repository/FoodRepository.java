package com.example.dietplan.repository;

import com.example.dietplan.domain.Food;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FoodRepository {

    private final EntityManager em;

    public void saveFood(Food food) {
        em.persist(food);
    }

    public Food findOne(Long foodId) {
        return em.find(Food.class, foodId);
    }
}
