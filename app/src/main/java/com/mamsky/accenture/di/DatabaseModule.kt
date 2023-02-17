package com.mamsky.accenture.di

import android.app.Application
import androidx.room.Room
import com.mamsky.accenture.data.local.AppDatabase
import com.mamsky.accenture.data.local.UserDetailFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "user_favorite_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserFavoriteDao(database: AppDatabase): UserDetailFavoriteDao {
        return database.userFavoriteDao()
    }

}