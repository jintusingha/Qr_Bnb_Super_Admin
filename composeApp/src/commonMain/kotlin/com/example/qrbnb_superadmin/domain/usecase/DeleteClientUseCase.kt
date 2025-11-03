package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.repository.DeleteClientRepository

class DeleteClientUseCase(
    private val repository: DeleteClientRepository,
) {
    suspend operator fun invoke(clientId: String) = repository.DeleteClient(clientId)
}
