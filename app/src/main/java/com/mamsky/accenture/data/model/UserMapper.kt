package com.mamsky.accenture.data.model

import com.mamsky.accenture.data.remote.response.UserResponse

object UserMapper {

    fun UserResponse.toViewParam() = UserViewParam(
        id = this.id,
        login = this.login ?: "",
        avatarUrl = this.avatarUrl ?: "",
        url = this.url ?: "",
        htmlUrl = this.htmlUrl ?: "",
        type = this.type ?: "",
        isFavorite = false,
    )

}