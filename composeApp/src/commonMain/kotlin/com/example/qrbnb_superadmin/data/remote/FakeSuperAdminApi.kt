package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.ApiResponse
import com.example.qrbnb_superadmin.data.remote.model.LoginDataDto
import kotlinx.coroutines.delay

class FakeSuperadminApi : SuperadminApi {
    private val VALID_EMAIL = "admin@qrbnb.io"
    private val VALID_PASSWORD = "StrongPassword123!"

    override suspend fun login(request: LoginRequest): ApiResponse<LoginDataDto> {
        delay(1000)

        return if (request.email == VALID_EMAIL && request.password == VALID_PASSWORD) {
            ApiResponse(
                success = true,
                message = "Login successful",
                data =
                    LoginDataDto(
                        userId = "01",
                        name = "suman",
                        email = request.email,
                        role = "SUPERADMIN",
                        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
                        refreshToken = "dGhpc2lzYXNhbXBsZXJlZnJlc2h0b2tlbg==",
                        expiresIn = 3600,
                    ),
            )
        } else {
            ApiResponse(
                success = false,
                message = "Invalid email or password",
                errorCode = "AUTH_INVALID_CREDENTIALS",
                data = null,
            )
        }
    }
}
