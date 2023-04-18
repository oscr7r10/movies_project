package com.example.domain.util

sealed class ResultApi<out R>() {
    data class Success<out T>(val data: T) : ResultApi<T>()
    data class Error(val error: Exception) : ResultApi<Nothing>()
}