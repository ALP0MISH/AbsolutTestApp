package com.example.tzapp.data.cache.source

import com.example.tzapp.data.cache.dao.UserDao
import com.example.tzapp.data.cache.models.UserCache
import javax.inject.Inject

class UserCacheDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : UserCacheDataSource {
    override suspend fun saveUser(user: UserCache) {
        return userDao.saveUser(user)
    }
}