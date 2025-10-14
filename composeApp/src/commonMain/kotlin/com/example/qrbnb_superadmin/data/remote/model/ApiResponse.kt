package com.example.qrbnb_superadmin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val errorCode: String? = null,
    val data: T? = null
)