package com.example.dietplan.service;

import com.example.dietplan.domain.Comments;
import com.example.dietplan.domain.Food;
import com.example.dietplan.domain.Nutri;
import com.example.dietplan.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public Long saveFood(Food food, Nutri nutri) {
        food.setNutri(nutri);
        foodRepository.saveFood(food);
        return food.getId();
    }

    public List<Comments> findComments(Long foodId) {
        Food findFood = foodRepository.findOne(foodId);
        return findFood.getComments();
    }
}
