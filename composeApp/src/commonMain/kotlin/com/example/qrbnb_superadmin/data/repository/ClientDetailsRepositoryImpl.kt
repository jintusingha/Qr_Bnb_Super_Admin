package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.ClientDetailsDataSource
import com.example.qrbnb_superadmin.domain.entity.ClientDetails
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository

class ClientDetailsRepositoryImpl(
    private val datasource: ClientDetailsDataSource,
) : ClientDetailsRepository {
    override suspend fun getClientDetails(clientId:String): ClientDetails {
        val response = datasource.getClientDetails(clientId)
        return response.toDomain()
    }
}
