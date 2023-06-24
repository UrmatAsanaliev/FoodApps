package com.example.foodapps.data.dto

import com.example.foodapps.domain.model.FoodModel

data class FoodDto(
    val id: String?,
    val img: String?,
    val name: String?,
    val dsc: String?,
    val price: Float?,
    val rate: Int?,
    val country: String?
)
    fun FoodDto.toDomain(): FoodModel = FoodModel(
        id, img, name, dsc, price, rate, country
    )

