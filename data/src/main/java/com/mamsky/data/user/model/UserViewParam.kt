package com.mamsky.data.user.model

data class UserViewParam(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val type: String,
    var isFavorite: Boolean = false,
)