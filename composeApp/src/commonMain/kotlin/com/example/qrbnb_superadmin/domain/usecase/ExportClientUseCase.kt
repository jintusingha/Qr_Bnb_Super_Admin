package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.ExportClientResponse
import com.example.qrbnb_superadmin.domain.repository.ExportClientRepository

class ExportClientUseCase (private val repository: ExportClientRepository){
    suspend operator fun invoke(clientId:String): ExportClientResponse{
        return repository.exportClient(clientId)
    }
}