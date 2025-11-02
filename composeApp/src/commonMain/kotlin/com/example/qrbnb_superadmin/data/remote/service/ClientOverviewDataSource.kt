package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsResponseDto

interface ClientOverviewDataSource {
    suspend fun getClients(): ClientsResponseDto
}