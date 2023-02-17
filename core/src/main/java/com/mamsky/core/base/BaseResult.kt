package com.mamsky.core.base

sealed class BaseResult<out T: Any> {
    data class Success<out T: Any>(val data: T) : BaseResult<T>()
    data class Error(val error: String?, val statusCode: Int): BaseResult<Nothing>()
    object Empty: BaseResult<Nothing>()
}