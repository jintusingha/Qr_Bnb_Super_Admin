package com.example.qrbnb_superadmin.domain.entity

data class User(
    val id: String,
    val email: String,
    val authToken: String,
    val refreshToken: String,
)
