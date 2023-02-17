package com.mamsky.accenture.data.repository

import com.mamsky.accenture.base.BaseResult
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.data.model.UserViewParam
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUsers(): BaseResult<List<UserViewParam>>

    suspend fun getUserDetails(userName: String): UserDetailViewParam

    suspend fun searchUsers(query: String): BaseResult<List<UserViewParam>>

    fun getFavorites(): Flow<List<UserViewParam>>

    fun searchUserFromDb(query: String): Flow<List<UserViewParam>>

    suspend fun saveUserAsFavorite(data: UserDetailViewParam)

    suspend fun clearUserAsFavorite(data: UserDetailViewParam)

    suspend fun isFavorite(id: Int): Boolean

    suspend fun isFavorite(userName: String): Boolean

}