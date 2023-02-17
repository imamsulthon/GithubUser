package com.mamsky.accenture.di

import android.app.Application
import androidx.room.Room
import com.mamsky.accenture.utils.APP_DATABASE_NAME
import com.mamsky.accenture.utils.AppDatabase
import com.mamsky.data.user.local.UserDetailFavoriteDao
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
            APP_DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserFavoriteDao(database: AppDatabase): UserDetailFavoriteDao {
        return database.userFavoriteDao()
    }

}