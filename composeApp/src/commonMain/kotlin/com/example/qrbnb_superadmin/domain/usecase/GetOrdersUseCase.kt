package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrdersResponse
import com.example.qrbnb_superadmin.domain.repository.OrderListRepository


class GetOrdersUseCase (private val repository: OrderListRepository){

    suspend operator fun invoke(): OrdersResponse{
        return repository.getDetails()
    }
}

