package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.DeleteClientRemoteDataSource
import com.example.qrbnb_superadmin.domain.entity.DeleteClientResponse
import com.example.qrbnb_superadmin.domain.repository.DeleteClientRepository

class DeleteClientImpl(
    private val dataSource: DeleteClientRemoteDataSource,
) : DeleteClientRepository {
    override suspend fun DeleteClient(clientId: String): DeleteClientResponse {
        val response = dataSource.deleteClient(clientId)
        return response.toDomain()
    }
}
