package com.mamsky.accenture.data.model

import com.mamsky.accenture.data.model.UserMapper.toViewParam
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
        id = this.id ?: 0,
        login = this.login ?: "",
        avatarUrl = this.avatarUrl ?: "",
        url = this.url ?: "",
        htmlUrl = this.htmlUrl ?: "",
        type = this.type ?: "",
        isFavorite = false,
        bio = this.bio,
        blog =  blog,
        company = company,
        email = email,
        followers = followers,
        followersUrl = followersUrl,
        following = following,
        followingUrl = followersUrl,
        location = location,
        name = name,
        organizationsUrl = organizationsUrl,
        reposUrl = reposUrl,
        siteAdmin = siteAdmin,
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
        followersUrl = "",
        following = 0,
        followingUrl = "",
        location = "",
        name = "",
        organizationsUrl = "",
        reposUrl =  "",
        siteAdmin =  false,
        twitterUsername = "",
    )

}