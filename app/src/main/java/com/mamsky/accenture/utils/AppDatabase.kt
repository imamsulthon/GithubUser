package com.mamsky.accenture.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mamsky.data.user.local.UserDetailEntity
import com.mamsky.data.user.local.UserDetailFavoriteDao

@Database(
    entities = [UserDetailEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userFavoriteDao(): UserDetailFavoriteDao

}