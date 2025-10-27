package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsResponse

interface OrderDataSource {
    suspend fun fetchOrderDetails(orderId: String): OrderDetailsResponse
}