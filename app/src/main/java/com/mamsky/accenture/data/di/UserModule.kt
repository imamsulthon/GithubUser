package com.mamsky.accenture.data.di

import com.mamsky.accenture.data.remote.api.UserApi
import com.mamsky.accenture.data.repository.UserRepository
import com.mamsky.accenture.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userApi: UserApi,
    ): UserRepository {
        return UserRepositoryImpl(userApi)
    }

}