package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.remote.service.LoginRequest
import com.example.qrbnb_superadmin.data.remote.service.SuperadminApi
import com.example.qrbnb_superadmin.domain.entity.User
import com.example.qrbnb_superadmin.domain.exception.InvalidCredentialsException
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository

class SuperadminRepositoryImpl(
    private val api: SuperadminApi,
) : SuperadminRepository {
    override suspend fun login(
        email: String,
        password: String,
    ): User {
        val request = LoginRequest(email, password)

        val response = api.login(request)

        if (response.success && response.data != null) {
            return User(
                id = response.data.userId,
                email = response.data.email,
                authToken = response.data.accessToken,
                refreshToken = response.data.refreshToken

            )
        } else {
            if (response.errorCode == "AUTH_INVALID_CREDENTIALS") {
                throw InvalidCredentialsException(response.message)
            } else {
                throw Exception(response.message)
            }
        }
    }
}
