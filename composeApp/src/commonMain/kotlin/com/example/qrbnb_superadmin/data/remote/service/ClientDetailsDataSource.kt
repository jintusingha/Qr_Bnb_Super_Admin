package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto

interface ClientDetailsDataSource {
    suspend fun getClientDetails(clientId:String): ClientDetailsDto
}