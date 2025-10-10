package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.User

interface SuperadminRepository {
    suspend fun login(email: String, password: String): User
}