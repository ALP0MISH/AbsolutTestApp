package com.example.tzapp.di

import android.content.Context
import androidx.room.Room
import com.example.tzapp.data.cache.dao.UserDao
import com.example.tzapp.data.cache.data_base.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val DATABASE_NAME = "database_name"


@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideUserDataBase(
        @ApplicationContext context: Context
    ): UserDataBase = Room.databaseBuilder(context, UserDataBase::class.java, DATABASE_NAME).build()

    @Provides
    fun provideUserDao(
        dataBase: UserDataBase
    ): UserDao = dataBase.userDao()

}