package com.mamsky.data.user.remote.api

import com.mamsky.data.user.remote.response.UserDetailResponse
import com.mamsky.data.user.remote.response.UserResponse
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