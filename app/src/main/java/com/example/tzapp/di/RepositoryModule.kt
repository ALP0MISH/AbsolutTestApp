package com.example.tzapp.di

import com.example.tzapp.domain.repository.UserRegisterRepository
import com.example.tzapp.data.repository.UserRegisterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsUserRegisterRepository(
        implementation: UserRegisterRepositoryImpl
    ): UserRegisterRepository
}