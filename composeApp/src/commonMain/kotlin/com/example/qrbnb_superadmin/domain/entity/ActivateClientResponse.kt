package com.example.qrbnb_superadmin.domain.entity

data class ActivateClientResponse(
    val clientId: String,
    val isActive: Boolean
)