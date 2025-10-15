package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.ClientDetails
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository
import com.example.qrbnb_superadmin.domain.repository.ClientRepository


class GetClientDetailsUseCase(private val repository: ClientDetailsRepository){
    suspend operator fun invoke(): ClientDetails{
        return repository.getClientDetails()

    }
}