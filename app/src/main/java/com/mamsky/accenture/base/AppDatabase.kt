package com.mamsky.accenture.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mamsky.accenture.data.local.UserDetailEntity
import com.mamsky.accenture.data.local.UserDetailFavoriteDao

@Database(
    entities = [UserDetailEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userFavoriteDao(): UserDetailFavoriteDao

}