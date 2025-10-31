package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsDto


interface OrderDataSource {
    suspend fun fetchOrderDetails(orderId: String): OrderDetailsDto
}