package com.mamsky.data.user.repository

import android.util.Log
import com.mamsky.core.base.BaseResult
import com.mamsky.data.user.local.UserDetailFavoriteDao
import com.mamsky.data.user.model.UserDetailViewParam
import com.mamsky.data.user.model.UserViewParam
import com.mamsky.data.user.model.mapper.UserMapper.emptyUserDetail
import com.mamsky.data.user.model.mapper.UserMapper.mapToViewParam
import com.mamsky.data.user.model.mapper.UserMapper.toEntity
import com.mamsky.data.user.model.mapper.UserMapper.toViewParam
import com.mamsky.data.user.remote.api.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val userDao: UserDetailFavoriteDao
): UserRepository {

    override suspend fun getUsers(): BaseResult<List<UserViewParam>> {
        return try {
            withContext(Dispatchers.IO) {
                val response = userApi.getUsers()
                val users = response.map { it.toViewParam() }
                when {
                    response.isEmpty() -> BaseResult.Error("error", 400)
                    users.isEmpty() -> BaseResult.Empty
                    else -> BaseResult.Success(users)
                }
            }
        } catch (e: Exception) {
            BaseResult.Error(e.message, 500)
        }
    }

    override suspend fun getUserDetails(userName: String): UserDetailViewParam {
        return try {
            withContext(Dispatchers.IO) {
                val response = userApi.getDetailUser(userName)
                response.toViewParam()
            }
        } catch (e: Exception) { e.printStackTrace()
            emptyUserDetail(userName)
        }
    }

    override suspend fun searchUsers(query: String): BaseResult<List<UserViewParam>> {
        return try {
            with(Dispatchers.IO) {
                val response = userApi.getSearchUser(query)
                val result = response.map { it.toViewParam() }
                when {
                    response.isNullOrEmpty() -> BaseResult.Error("error", 400)
                    result.isNullOrEmpty() -> BaseResult.Empty
                    else -> BaseResult.Success(result)
                }
            }
        } catch(e: Exception) { e.printStackTrace()
            BaseResult.Error(e.message, 500)
        }
    }

    override fun getFavorites(): Flow<List<UserViewParam>> {
        return userDao.fetchAllUsers().map { it.mapToViewParam() }
    }

    override fun searchUserFromDb(query: String): Flow<List<UserViewParam>> {
        return userDao.getByUsername(query).map { it.mapToViewParam() }
    }

    override suspend fun saveUserAsFavorite(data: UserDetailViewParam) {
        return userDao.addAsFavorite(data.toEntity())
    }

    override suspend fun clearUserAsFavorite(data: UserDetailViewParam) {
        return userDao.deleteFromFavorite(data.toEntity())
    }

    override suspend fun isFavorite(id: Int): Boolean {
        return try {
            withContext(Dispatchers.IO) {
                val existed = userDao.isUserExisted(id)
                existed
            }
        } catch (e: Exception) { e.printStackTrace()
            false
        }
    }

    override suspend fun isFavorite(userName: String): Boolean {
        return try {
            withContext(Dispatchers.IO) {
                val existed = userDao.isUserExisted(userName)
                existed
            }
        } catch (e: Exception) { e.printStackTrace()
            false
        }
    }

    private fun printLog(msg: String) {
        Log.d("UserRepository", msg)
    }

}