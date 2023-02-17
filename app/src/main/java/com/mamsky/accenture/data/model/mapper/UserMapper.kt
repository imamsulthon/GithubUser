package com.mamsky.accenture.data.model.mapper

import com.mamsky.accenture.data.local.UserDetailEntity
import com.mamsky.accenture.data.model.UserDetailViewParam
import com.mamsky.accenture.data.model.UserViewParam
import com.mamsky.accenture.data.remote.response.UserDetailResponse
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

    fun UserDetailResponse.toViewParam() = UserDetailViewParam(
        id = id ?: 0,
        login = login ?: "",
        avatarUrl = avatarUrl ?: "",
        url = url ?: "",
        htmlUrl = htmlUrl ?: "",
        type = type ?: "",
        bio = bio,
        blog =  blog,
        company = company,
        email = email,
        followers = followers,
        following = following,
        location = location,
        name = name,
        organizationsUrl = organizationsUrl,
        reposUrl = reposUrl,
        twitterUsername = twitterUsername,
    )

    fun emptyUserDetail(userName: String? = null) = UserDetailViewParam(
        id = 0,
        login = userName ?: "",
        avatarUrl = "",
        url = "",
        htmlUrl = "",
        type = "",
        isFavorite = false,
        bio = "",
        blog =  "",
        company = "",
        email = "",
        followers = 0,
        following = 0,
        location = "",
        name = "",
        organizationsUrl = "",
        reposUrl =  "",
        twitterUsername = "",
    )

    fun List<UserDetailEntity>.mapToViewParam(): List<UserViewParam> {
        return this.map { it.toViewParamItem() }
    }

    fun UserDetailViewParam.toEntity() = UserDetailEntity(
        id = this.id ?: 0,
        username = login,
        avatarUrl = avatarUrl ?: "",
        bio = bio,
        company = company,
        followers = followers,
        following = following,
        location = location,
        url = url ?: "",
        htmlUrl = htmlUrl ?: "",
        type = type ?: "",
        name = name,
        blog = blog,
        email = email,
        organizationsUrl = organizationsUrl,
        reposUrl = reposUrl,
        twitterUsername = twitterUsername,
    )

    fun UserDetailEntity.toViewParamItem() = UserViewParam(
        id = id,
        login = username ?: "",
        avatarUrl = avatarUrl ?: "",
        url = url ?: "",
        htmlUrl = htmlUrl ?: "",
        type = type ?: "",
    )

    fun UserDetailEntity.toViewParamDetail() = UserDetailViewParam(
        id = id,
        login = username,
        avatarUrl = avatarUrl ?: "",
        url = url ?: "",
        htmlUrl = htmlUrl ?: "",
        type = type ?: "",
        bio = bio,
        blog =  blog,
        company = company,
        email = email,
        followers = followers,
        following = following,
        location = location,
        name = name,
        organizationsUrl = organizationsUrl,
        reposUrl = reposUrl,
        twitterUsername = twitterUsername,
    )

}