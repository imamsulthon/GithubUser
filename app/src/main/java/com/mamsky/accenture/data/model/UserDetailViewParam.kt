package com.mamsky.accenture.data.model

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
    val email: Any?,
    val followers: Int?,
    val followersUrl: String?,
    val following: Int?,
    val followingUrl: String?,
    val location: String?,
    val name: String?,
    val organizationsUrl: String?,
    val reposUrl: String?,
    val siteAdmin: Boolean?,
    val twitterUsername: String?,
    val isFavorite: Boolean = false
)
