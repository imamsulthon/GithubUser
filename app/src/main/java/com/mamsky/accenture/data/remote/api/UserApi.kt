package com.mamsky.accenture.data.remote.api

import com.mamsky.accenture.data.remote.response.UserDetailResponse
import com.mamsky.accenture.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("search/users?")
    suspend fun getSearchUser(
        @Query("q") q : String
    ) : List<UserResponse>

    @GET("users/{username}")
    suspend fun getDetailUser(
        @Path("username") username: String
    ) : UserDetailResponse

}