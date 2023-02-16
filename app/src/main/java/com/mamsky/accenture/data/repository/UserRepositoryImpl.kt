package com.mamsky.accenture.data.repository

import android.util.Log
import com.mamsky.accenture.base.BaseResult
import com.mamsky.accenture.data.DummyExt
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.data.model.UserMapper.emptyUserDetail
import com.mamsky.accenture.data.model.UserMapper.toViewParam
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.data.remote.api.UserApi
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
): UserRepository {

    override suspend fun getUsers(): BaseResult<List<UserViewParam>> {
        return try {
            with(Dispatchers.IO) {
                val response = userApi.getUsers()
                val users = response.map { it.toViewParam() }
                when {
                    response.isNullOrEmpty() -> BaseResult.Error("error", 400)
                    users.isEmpty() || users.isNullOrEmpty() -> BaseResult.Empty
                    else -> BaseResult.Success(users)
                }
            }
        } catch (e: Exception) {
            BaseResult.Error(e.message, 500)
        }
    }

    override suspend fun getUserDetails(userName: String): UserDetailViewParam {
        return with(Dispatchers.IO) {
            try {
                val response = userApi.getDetailUser(userName)
                response.toViewParam()
            } catch (e: Exception) {
                e.printStackTrace()
                emptyUserDetail(userName)
            }
        }
    }

    override suspend fun searchUsers(query: String): BaseResult<List<UserViewParam>> {
        return with(Dispatchers.IO) {
            try {
                val response = userApi.getSearchUser(query)
                val result = response.map { it.toViewParam() }
                when {
                    response.isNullOrEmpty() -> BaseResult.Error("error", 400)
                    result.isNullOrEmpty() -> BaseResult.Empty
                    else -> BaseResult.Success(result)
                }

            } catch (e: Exception) {
                BaseResult.Error(e.message, 500)
            }
        }
    }

    override suspend fun getFavorites(): List<UserViewParam> {
        // todo implement real database
        with(Dispatchers.IO) {
            val response = DummyExt.getDummyResponse()
            printLog("data size ${response.size} data $response")
            return response.map {
                it.toViewParam().apply { isFavorite = true }
            }
        }
    }

    private fun printLog(msg: String) {
        Log.d("UserRepository", msg)
    }

}