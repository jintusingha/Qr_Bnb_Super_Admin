package com.example.qrbnb_superadmin.domain.usecase

import com.example.qrbnb_superadmin.domain.entity.OrderListData
import com.example.qrbnb_superadmin.domain.repository.OrderListRepository

class GetOrdersUseCase(
    private val repository: OrderListRepository,
) {
    suspend operator fun invoke(
        clientId: String,
        status: String? = null,
    ): OrderListData = repository.getOrderList(clientId, status)
}
