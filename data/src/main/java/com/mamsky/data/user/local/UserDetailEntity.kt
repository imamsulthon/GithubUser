package com.mamsky.data.user.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_favorite_table")
data class UserDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String?,
    @ColumnInfo(name = "html_url") val htmlUrl: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "bio") val bio: String?,
    @ColumnInfo(name = "blog") val blog: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "company") val company: String?,
    @ColumnInfo(name = "followers") val followers: Int?,
    @ColumnInfo(name = "following") val following: Int?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "organizationsUrl") val organizationsUrl: String?,
    @ColumnInfo(name = "reposUrl") val reposUrl: String?,
    @ColumnInfo(name = "twitterUsername") val twitterUsername: String?,
)