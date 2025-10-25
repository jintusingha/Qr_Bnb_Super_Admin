package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.FormSchema

interface NewClientRepository {
    suspend fun getAddClientFormSchema(): FormSchema
    suspend fun submitAddClientForm(formValues: Map<String, Any>): AddClientResponseDto
}
