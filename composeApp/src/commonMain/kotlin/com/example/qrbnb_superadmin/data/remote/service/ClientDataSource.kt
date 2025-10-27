package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsResponseDto

interface ClientDataSource {
    suspend fun getClients(): ClientsResponseDto
}