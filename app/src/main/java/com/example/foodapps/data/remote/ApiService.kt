package com.example.foodapps.data.remote

import com.example.foodapps.data.dto.FoodDto
import retrofit2.http.GET

interface ApiService {

//    @GET("breads")
//    suspend fun getFood(food: String): List<FoodDto> {
//        return when (food) {
//            "burgers" -> getBurgers()
//            "porks" -> getPorks()
//            "pizzas" -> getPizzas()
//            "ice-cream" -> getIceCream()
//            "fried-chicken" -> getFriedChicken()
//            "drinks" -> getDrinks()
//            "desserts" -> getDesserts()
//            "chocolates" -> getChocolates()
//            "breads" -> getBreads()
//            else -> {
//                getBreads()
//            }
//        }
//    }

    @GET("breads")
    suspend fun getBreads(): List<FoodDto>

    @GET("burgers")
    suspend fun getBurgers(): List<FoodDto>

    @GET("chocolates")
    suspend fun getChocolates(): List<FoodDto>

    @GET("desserts")
    suspend fun getDesserts(): List<FoodDto>

    @GET("drinks")
    suspend fun getDrinks(): List<FoodDto>

    @GET("fried-chicken")
    suspend fun getFriedChicken(): List<FoodDto>

    @GET("ice-cream")
    suspend fun getIceCream(): List<FoodDto>

    @GET("pizzas")
    suspend fun getPizzas(): List<FoodDto>

    @GET("porks")
    suspend fun getPorks(): List<FoodDto>


}