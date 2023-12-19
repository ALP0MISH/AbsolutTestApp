package com.example.tzapp.domain.use_case

import com.example.tzapp.domain.models.UserDomain

interface UserRegisterUseCase {

    suspend fun saveUser(userModel: UserDomain)
}