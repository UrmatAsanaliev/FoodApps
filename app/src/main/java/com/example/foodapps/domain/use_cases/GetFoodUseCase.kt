package com.example.foodapps.domain.use_cases

import com.example.foodapps.domain.repo.FoodRepository
import javax.inject.Inject

class GetFoodUseCase @Inject constructor(
    private val repo: FoodRepository
) {
    operator fun invoke(food: String) = repo.getFood(food)
}