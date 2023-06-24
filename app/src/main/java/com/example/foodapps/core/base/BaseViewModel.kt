package com.example.foodapps.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapps.core.Resource
import com.example.foodapps.core.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    protected fun <T> mutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Loading())

    protected fun <T, S> Flow<Resource<T>>.gatherRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (data: T) -> S,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@gatherRequest.collect {
                when (it) {
                    is Resource.Error -> state.value = UIState.Error(it.message!!)
                    is Resource.Loading -> state.value = UIState.Loading()
                    is Resource.Success -> state.value =
                        UIState.Success(mappedData(it.data!!))
                }
            }
        }
    }
}