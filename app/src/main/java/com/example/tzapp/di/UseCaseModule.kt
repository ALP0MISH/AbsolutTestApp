package com.example.tzapp.di

import com.example.tzapp.domain.use_case.UserRegisterUseCase
import com.example.tzapp.domain.use_case.UserRegisterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsUserRegisterUseCaseImpl(
        implementation: UserRegisterUseCaseImpl
    ): UserRegisterUseCase

}