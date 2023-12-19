package com.example.tzapp.domain.use_case

import com.example.tzapp.domain.models.UserDomain
import com.example.tzapp.domain.repository.UserRegisterRepository
import javax.inject.Inject

class UserRegisterUseCaseImpl @Inject constructor(
    private val userRegisterRepository: UserRegisterRepository
) : UserRegisterUseCase {

    override suspend fun saveUser(userModel: UserDomain) {
        userRegisterRepository.saveUser(userModel)
    }
}