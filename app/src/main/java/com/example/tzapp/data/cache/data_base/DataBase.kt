package com.example.tzapp.data.cache.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tzapp.data.cache.dao.UserDao
import com.example.tzapp.data.cache.models.UserCache

@Database(
    entities = [UserCache::class],
    version = 1
)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}