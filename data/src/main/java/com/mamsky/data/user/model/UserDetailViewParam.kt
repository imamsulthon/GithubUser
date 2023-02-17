package com.mamsky.data.user.model

data class UserDetailViewParam(
    val id: Int,
    val login: String,
    val url: String,
    val htmlUrl: String,
    val type: String,
    val avatarUrl: String?,
    val bio: String?,
    val blog: String?,
    val company: String?,
    val email: String?,
    val followers: Int?,
    val following: Int?,
    val location: String?,
    val name: String?,
    val organizationsUrl: String?,
    val reposUrl: String?,
    val twitterUsername: String?,
    val isFavorite: Boolean = false
)
