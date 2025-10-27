package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.AddNewClientDataSource
import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.FormSchema
import com.example.qrbnb_superadmin.domain.repository.NewClientRepository

class NewClientRepositoryImpl(
    private val dataSource: AddNewClientDataSource
) : NewClientRepository {

    override suspend fun getAddClientFormSchema(): FormSchema {

        val response = dataSource.getAddClientFormSchema()


        return response.toDomain()
    }
    override suspend fun submitAddClientForm(formValues: Map<String, Any>): AddClientResponseDto {
        return dataSource.submitAddClientForm(formValues)
    }
}