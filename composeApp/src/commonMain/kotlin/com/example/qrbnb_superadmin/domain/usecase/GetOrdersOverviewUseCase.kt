package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrdersOverview
import com.example.qrbnb_superadmin.domain.repository.OrdersOverviewRepository

class GetOrdersOverviewUseCase(
    private val repository: OrdersOverviewRepository,
) {
    suspend operator fun invoke(): OrdersOverview = repository.getOrdersOverview()
}
