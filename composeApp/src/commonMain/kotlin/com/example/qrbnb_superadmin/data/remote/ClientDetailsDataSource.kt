package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto

interface ClientDetailsDataSource {
    suspend fun getClientDetails(): ClientDetailsDto
}
