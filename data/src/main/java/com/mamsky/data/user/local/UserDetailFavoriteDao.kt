package com.mamsky.data.user.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDetailFavoriteDao {

    @Query("SELECT * FROM user_favorite_table")
    fun fetchAllUsers(): Flow<List<UserDetailEntity>>

    @Query("SELECT * FROM user_favorite_table WHERE username = :userName")
    fun getByUsername(userName: String) : Flow<List<UserDetailEntity>>

    @Query("SELECT EXISTS(SELECT * FROM user_favorite_table WHERE username = :userName)")
    suspend fun isUserExisted(userName: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM user_favorite_table WHERE id = :id)")
    suspend fun isUserExisted(id: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAsFavorite(userEntity: UserDetailEntity)

    @Delete
    suspend fun deleteFromFavorite(userEntity: UserDetailEntity)

}