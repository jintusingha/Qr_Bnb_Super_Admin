package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.domain.repository.NewClientRepository

class SubmitAddClientFormUseCase(
    private val repository: NewClientRepository
) {

    suspend operator fun invoke(formValues: Map<String, Any>): AddClientResponseDto {
        return repository.submitAddClientForm(formValues)
    }
}
