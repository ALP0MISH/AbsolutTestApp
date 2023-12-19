package com.example.tzapp.data.cache.source

import com.example.tzapp.data.cache.models.UserCache

interface UserCacheDataSource {
    suspend fun saveUser(user: UserCache)
}