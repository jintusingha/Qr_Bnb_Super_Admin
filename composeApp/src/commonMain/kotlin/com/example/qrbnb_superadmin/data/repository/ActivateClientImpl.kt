package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.ActivateClientRemoteDataSource
import com.example.qrbnb_superadmin.domain.entity.ActivateClientResponse
import com.example.qrbnb_superadmin.domain.repository.ActivateClientRepository

class ActivateClientImpl (private val dataSource: ActivateClientRemoteDataSource): ActivateClientRepository {
    override suspend fun activateClient(clientId: String): ActivateClientResponse {
        val response=dataSource.activateClient(clientId)
        return response.toDomain()

    }
}