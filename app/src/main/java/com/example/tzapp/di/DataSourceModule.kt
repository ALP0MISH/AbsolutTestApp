package com.example.tzapp.di

import com.example.tzapp.data.cache.source.UserCacheDataSource
import com.example.tzapp.data.cache.source.UserCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun provideUserCacheDataSource(
        implementation: UserCacheDataSourceImpl
    ): UserCacheDataSource

}