package com.example.foodapps.domain.repo

import com.example.foodapps.core.Resource
import com.example.foodapps.domain.model.FoodModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getFood(food: String): Flow<Resource<List<FoodModel>>>
}