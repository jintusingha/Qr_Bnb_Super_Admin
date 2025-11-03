package com.example.qrbnb_superadmin.domain.entity

data class ActivateClient(
    val clientId: String,
    val isActive: Boolean
)