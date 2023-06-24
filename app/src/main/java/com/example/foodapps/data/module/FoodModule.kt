package com.example.foodapps.data.module

import com.example.foodapps.data.repo.FoodRepositoryImpl
import com.example.foodapps.domain.repo.FoodRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FoodModule {

    @Binds
    fun bindFoodRepo(
        foodRepositoryImpl: FoodRepositoryImpl
    ): FoodRepository
}