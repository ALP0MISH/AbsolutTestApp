package com.example.tzapp.di

import com.example.tzapp.domain.use_case.ShowToastUseCase
import com.example.tzapp.domain.use_case.ToastManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ManagersModule {
    @Binds
    @Singleton
    fun bindShowToastUseCase(
        impl: ToastManager
    ): ShowToastUseCase
}