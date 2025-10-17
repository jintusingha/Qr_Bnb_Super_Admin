package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.FormSchema
import com.example.qrbnb_superadmin.domain.repository.ClientRepository
import com.example.qrbnb_superadmin.domain.repository.NewClientRepository

class GetAddClientFormUseCase(
    private val repository: NewClientRepository
) {

    suspend operator fun invoke(): FormSchema {

        return repository.getAddClientFormSchema()
    }
}
