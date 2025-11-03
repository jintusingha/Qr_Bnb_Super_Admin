package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.ActivateClientResponse


interface ActivateClientRepository{
    suspend fun activateClient(clientId:String): ActivateClientResponse
}