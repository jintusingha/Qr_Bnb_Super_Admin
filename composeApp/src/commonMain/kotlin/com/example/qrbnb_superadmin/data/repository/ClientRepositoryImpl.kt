package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toClient
import com.example.qrbnb_superadmin.data.mapper.toClientOverview
import com.example.qrbnb_superadmin.data.remote.service.ClientDataSource
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview
import com.example.qrbnb_superadmin.domain.repository.ClientRepository


class ClientRepositoryImpl(
    private val dataSource: ClientDataSource
) : ClientRepository {

    override suspend fun getAllClients(): List<Client> {
        val response = dataSource.getClients()
        return response.data.clients.map { it.toClient() }
    }

    override suspend fun getOverviewCounts(): ClientOverview {
        val response = dataSource.getClients()
        return response.data.summary.toClientOverview()
    }
}