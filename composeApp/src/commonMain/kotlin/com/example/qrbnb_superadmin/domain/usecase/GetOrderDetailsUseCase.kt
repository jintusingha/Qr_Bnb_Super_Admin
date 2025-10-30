package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.domain.repository.OrderDetailsRepository

class GetOrderDetailsUseCase(
    private val repository: OrderDetailsRepository,
) {
    suspend operator fun invoke(orderId: String): Result<OrderDetails> = repository.getOrderDetails(orderId)
}
