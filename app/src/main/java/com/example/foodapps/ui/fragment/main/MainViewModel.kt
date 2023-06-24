package com.example.foodapps.ui.fragment.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapps.core.Resource
import com.example.foodapps.core.UIState
import com.example.foodapps.core.base.BaseViewModel
import com.example.foodapps.domain.model.FoodModel
import com.example.foodapps.domain.use_cases.GetFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFoodUseCase: GetFoodUseCase
): BaseViewModel() {

    private val _getFood = MutableStateFlow<UIState<List<FoodModel>>>(UIState.Loading())
    val getFood = _getFood.asStateFlow()

    fun getFood(food: String) = getFoodUseCase(food)
        .gatherRequest(_getFood) { data -> data.map { it }}
}