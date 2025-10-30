package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrdersResponse
import com.example.qrbnb_superadmin.domain.repository.OrdersRepository


class GetOrdersUseCase (private val repository: OrdersRepository){

    suspend operator fun invoke(): OrdersResponse{
        return repository.getDetails()
    }
}

