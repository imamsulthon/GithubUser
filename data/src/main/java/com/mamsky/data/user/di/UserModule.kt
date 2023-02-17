package com.mamsky.data.user.di

import com.mamsky.data.user.local.UserDetailFavoriteDao
import com.mamsky.data.user.remote.api.UserApi
import com.mamsky.data.user.repository.UserRepository
import com.mamsky.data.user.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userApi: UserApi,
        userDao: UserDetailFavoriteDao,
    ): UserRepository {
        return UserRepositoryImpl(userApi, userDao)
    }

}