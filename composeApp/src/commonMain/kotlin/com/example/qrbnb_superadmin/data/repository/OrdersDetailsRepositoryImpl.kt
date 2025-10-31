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
            val orderDetailsDto = dataSource.fetchOrderDetails(orderId)

            val orderDetails = orderDetailsDto.toDomain()

            // Return success result
            Result.success(orderDetails)
        } catch (e: Exception) {
            // Handle error and wrap it in Result
            Result.failure(e)
        }


}
