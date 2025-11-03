package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.repository.ActivateClientRepository

class ActivateClientUseCase(
    private val repository: ActivateClientRepository,
) {
    suspend operator fun invoke(clientId: String) = repository.activateClient(clientId)
}
