package com.example.qrbnb_superadmin.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)