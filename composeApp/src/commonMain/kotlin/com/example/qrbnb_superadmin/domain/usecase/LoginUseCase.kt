package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.data.TokenStorage
import com.example.qrbnb_superadmin.domain.entity.User
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.logging.Logger

class LoginUseCase(
    private val repository: SuperadminRepository,
    private val tokenStorage: TokenStorage,
) {
    suspend operator fun invoke(
        email: String,
        password: String,
    ): User {
        val user = repository.login(email, password)

        Logger.d("Token_check_api", "Received access token: ${user.authToken}")
        Logger.d("Token_check_api", "Received refresh token: ${user.refreshToken}")

        tokenStorage.saveTokens(user.authToken, user.refreshToken)

        val access = tokenStorage.getAccessToken()
        val refresh = tokenStorage.getRefreshToken()

        Logger.d("Token_check_storage", "Stored access token: $access")
        Logger.d("Token_check_storage", "Stored refresh token: $refresh")

        return user
    }
}
