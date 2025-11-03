package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDataDto
import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDto

interface ExportClientRemoteDataSource {
    suspend fun exportClient(clientId: String): ExportClientDto
}
