package com.mamsky.accenture.data.repository

import com.mamsky.accenture.base.BaseResult
import com.mamsky.accenture.data.model.UserViewParam

interface UserRepository {

    suspend fun getUsers(): BaseResult<List<UserViewParam>>

    suspend fun getUserDetails(id: Int): UserViewParam

    suspend fun searchUsers(query: String): BaseResult<List<UserViewParam>>

    suspend fun getFavorites(): List<UserViewParam>

}