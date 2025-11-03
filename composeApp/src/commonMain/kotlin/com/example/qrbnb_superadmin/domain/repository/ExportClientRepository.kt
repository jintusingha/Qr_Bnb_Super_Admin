package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.ExportClientResponse


interface ExportClientRepository{
    suspend fun exportClient(clientId:String): ExportClientResponse
}