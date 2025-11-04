package com.example.qrbnb_superadmin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RefreshRequest(
    val refreshToken: String,
)

@Serializable
data class RefreshResponse(
    val success: Boolean,
    val message: String,
    val data: RefreshData,
)

@Serializable
data class RefreshData(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long,
)
