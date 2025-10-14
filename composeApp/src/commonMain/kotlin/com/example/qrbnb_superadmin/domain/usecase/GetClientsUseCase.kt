package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.repository.ClientRepository


class GetClientsUseCase (private val repository: ClientRepository){
    suspend operator fun invoke():List<Client>{
        return repository.getAllClients()
    }
}