package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.ClientOverview
import com.example.qrbnb_superadmin.domain.repository.ClientRepository


class GetClientsOverviewUseCase (
    private val repository: ClientRepository
){
    suspend operator fun invoke(): ClientOverview{
        return repository.getOverviewCounts()
    }
}