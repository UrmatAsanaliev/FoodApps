package com.example.foodapps.core.base

import com.example.foodapps.core.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> makeNetworkRequest(
    gatherIsSucceed: ((T) -> Unit)? = null,
    request: suspend () -> T
) = flow {
    emit(Resource.Loading())
    request().also {
        gatherIsSucceed?.invoke(it)
        emit(Resource.Success(data = it))
    }
}.flowOn(Dispatchers.IO).catch {msg ->
    emit(Resource.Error(msg.localizedMessage ?: "Error Occurred!"))
}