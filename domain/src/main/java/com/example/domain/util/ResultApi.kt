package com.example.domain.util

sealed class ResultApi<out T : Any?> {
    data class OnSuccess<out T : Any?>(val data: T) : ResultApi<T>()
    data class OnFailure(val errorType: ErrorType, val message: String, val errorCode: String = "") : ResultApi<Nothing>()
    object OnLoading : ResultApi<Nothing>()
}