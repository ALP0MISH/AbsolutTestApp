package com.example.tzapp.data.repository

import com.example.tzapp.data.cache.source.UserCacheDataSource
import com.example.tzapp.data.mappers.toCache
import com.example.tzapp.domain.models.UserDomain
import com.example.tzapp.domain.repository.UserRegisterRepository
import javax.inject.Inject

class UserRegisterRepositoryImpl @Inject constructor(
    private val userCacheDataSource: UserCacheDataSource
) : UserRegisterRepository {

    override suspend fun saveUser(userCache: UserDomain) {
        userCacheDataSource.saveUser(userCache.toCache())
    }
}