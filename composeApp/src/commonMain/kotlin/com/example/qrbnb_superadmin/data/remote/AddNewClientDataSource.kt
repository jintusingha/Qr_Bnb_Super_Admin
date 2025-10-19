package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormSchemaResponse

interface AddNewClientDataSource {
    suspend fun getAddClientFormSchema(): FormSchemaResponse
    suspend fun submitAddClientForm(formValues: Map<String, Any>): AddClientResponseDto
}
