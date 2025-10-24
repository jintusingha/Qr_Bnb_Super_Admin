package com.example.qrbnb_superadmin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginDataDto(
    val userId: String,

    val email: String,
    val role: String,
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int
)