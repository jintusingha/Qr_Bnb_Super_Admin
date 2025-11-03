package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.ExportClientRemoteDataSource
import com.example.qrbnb_superadmin.domain.entity.ExportClientResponse
import com.example.qrbnb_superadmin.domain.repository.ExportClientRepository

class ExportClientImpl (private val datasource: ExportClientRemoteDataSource): ExportClientRepository{
    override suspend fun exportClient(clientId: String): ExportClientResponse {
        val response=datasource.exportClient(clientId)
        return response.toDomain()

    }

}