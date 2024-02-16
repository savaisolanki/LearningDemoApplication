package com.example.learningdemoapplication.utils

/*
* Response Handler Class
* */
sealed class ResponseHandler<out T> {
    data object Loading : ResponseHandler<Nothing>()
    class OnFailed(val code: Throwable?) : ResponseHandler<Nothing>()
    class OnSuccessResponse<T>(val response: List<T>) : ResponseHandler<T>()
}