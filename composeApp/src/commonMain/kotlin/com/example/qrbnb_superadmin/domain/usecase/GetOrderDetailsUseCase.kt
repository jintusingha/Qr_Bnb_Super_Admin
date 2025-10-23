package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.domain.repository.OrderRepository

class GetOrderDetailsUseCase(
    private val repository: OrderRepository,
) {
    suspend operator fun invoke(orderId: String): Result<OrderDetails> = repository.getOrderDetails(orderId)
}
