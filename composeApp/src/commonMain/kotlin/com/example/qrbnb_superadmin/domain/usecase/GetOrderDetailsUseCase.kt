package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.domain.repository.OrderRepository

class GetOrderDetailsUseCase(
    private val repository: OrderRepository // Depends on the Repository Interface
) {
    /**
     *
     */
    suspend operator fun invoke(orderId: String): Result<OrderDetails> {
        // This layer is responsible for application-level logic (e.g., logging, validation,
        // deciding between multiple repositories/data sources, checking cached data).

        // For a simple fetch, it just calls the repository:
        return repository.getOrderDetails(orderId)
    }
}