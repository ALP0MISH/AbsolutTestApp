package com.example.tzapp.domain.repository

import com.example.tzapp.domain.models.UserDomain

interface UserRegisterRepository {

    suspend fun saveUser(userCache: UserDomain)
}