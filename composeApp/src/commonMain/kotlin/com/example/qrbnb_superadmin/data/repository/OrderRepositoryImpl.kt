package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.OrderDataSource
import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val dataSource: OrderDataSource // Injected dependency (real network or fake test)
) : OrderRepository {

    override suspend fun getOrderDetails(orderId: String): Result<OrderDetails> {
        return try {
            // 1. Get raw DTO from the source
            val response = dataSource.fetchOrderDetails(orderId)

            if (response.success && response.data != null) {
                // 2. Convert DTO to Domain Entity using the extension function
                Result.success(response.data.toDomain())
            } else {
                // Handle API-reported failure
                Result.failure(Exception("Could not load order details: API failed."))
            }
        } catch (e: Exception) {
            // Handle network or JSON parsing errors
            Result.failure(e)
        }
    }
}