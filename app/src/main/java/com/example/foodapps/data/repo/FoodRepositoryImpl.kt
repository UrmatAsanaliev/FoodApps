package com.example.foodapps.data.repo

import com.example.foodapps.core.Resource
import com.example.foodapps.core.base.makeNetworkRequest
import com.example.foodapps.data.dto.toDomain
import com.example.foodapps.data.remote.ApiService
import com.example.foodapps.domain.model.FoodModel
import com.example.foodapps.domain.repo.FoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val api: ApiService
): FoodRepository {
    override fun getFood(food: String): Flow<Resource<List<FoodModel>>> {
        return when (food) {
            "breads" -> getBreads()
            "burgers" -> getBurgers()
            "chocolates" -> getChocolate()
            "desserts" -> getDesserts()
            "drinks" -> getDrinks()
            "fried_chicken" -> getFried()
            "ice_cream" -> getIceCream()
            "pizzas" -> getPizzas()
            "porks" -> getPorks()
            else ->{
                getBreads()
            }
        }
    }

    private fun getBreads(): Flow<Resource<List<FoodModel>>> =
        makeNetworkRequest {
            api.getBreads().map { it.toDomain() }
        }

    private fun getChocolate(): Flow<Resource<List<FoodModel>>> =
        makeNetworkRequest {
            api.getChocolates().map { it.toDomain() }
        }

    private fun getDesserts(): Flow<Resource<List<FoodModel>>> =
    makeNetworkRequest {
        api.getDesserts().map { it.toDomain() }
    }

    private fun getDrinks(): Flow<Resource<List<FoodModel>>> =
        makeNetworkRequest {
            api.getDrinks().map { it.toDomain() }
        }

    private fun getFried(): Flow<Resource<List<FoodModel>>>  =
        makeNetworkRequest {
            api.getFriedChicken().map { it.toDomain() }
        }

    private fun getIceCream(): Flow<Resource<List<FoodModel>>>  =
        makeNetworkRequest {
            api.getIceCream().map { it.toDomain() }
        }

    private fun getPizzas(): Flow<Resource<List<FoodModel>>>  =
        makeNetworkRequest {
            api.getPizzas().map { it.toDomain() }
        }

    private fun getPorks(): Flow<Resource<List<FoodModel>>>  =
        makeNetworkRequest {
            api.getPorks().map { it.toDomain() }
        }

    private fun getBurgers(): Flow<Resource<List<FoodModel>>>  =
        makeNetworkRequest {
            api.getBurgers().map { it.toDomain() }
        }
}