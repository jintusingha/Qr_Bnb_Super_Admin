package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.OrderDetails

interface OrderDetailsRepository {
    suspend fun getOrderDetails(orderId: String): Result<OrderDetails>
}