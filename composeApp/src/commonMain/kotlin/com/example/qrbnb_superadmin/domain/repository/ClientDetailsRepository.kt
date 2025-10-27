package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.ClientDetails


interface ClientDetailsRepository {
    suspend fun getClientDetails(clientId:String): ClientDetails
}