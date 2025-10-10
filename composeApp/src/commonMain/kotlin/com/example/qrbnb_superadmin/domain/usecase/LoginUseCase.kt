package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.User
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository

class LoginUseCase(private val repository: SuperadminRepository) {
    suspend operator fun invoke(email: String, password: String): User {
        return repository.login(email, password)
    }
}