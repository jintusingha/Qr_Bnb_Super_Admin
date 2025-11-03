package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.ActivateClient


interface ActivateClientRepository{
    suspend fun activateClient(clientId:String): ActivateClient
}