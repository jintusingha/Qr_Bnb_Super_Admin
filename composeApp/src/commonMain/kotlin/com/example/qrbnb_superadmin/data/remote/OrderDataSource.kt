package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsResponse

interface OrderDataSource {
    suspend fun fetchOrderDetails(orderId: String): OrderDetailsResponse
}