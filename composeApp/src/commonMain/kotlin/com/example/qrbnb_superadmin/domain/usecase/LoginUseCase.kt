package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.data.TokenStorage
import com.example.qrbnb_superadmin.domain.entity.User
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.logging.Logger

class LoginUseCase(private val repository: SuperadminRepository,
    private val tokenStorage: TokenStorage) {
    suspend operator fun invoke(email: String, password: String): User {
        val user=repository.login(email,password)
        Logger.d("Token_check_api","Received token:${user.authToken}")
        tokenStorage.saveToken(user.authToken)
        val store=tokenStorage.getToken()
        Logger.d("Token_check_storage","stored token value :$store")


        return user
    }
}