package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.OrderDataSource
import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.domain.repository.OrderDetailsRepository

class OrdersDetailsRepositoryImpl(
    private val dataSource: OrderDataSource,
) : OrderDetailsRepository {
    override suspend fun getOrderDetails(orderId: String): Result<OrderDetails> =
        try {
            val response = dataSource.fetchOrderDetails(orderId)

            if (response.success && response.data != null) {
                Result.success(response.data.toDomain())
            } else {
                Result.failure(Exception("Could not load order details: API failed."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
}
