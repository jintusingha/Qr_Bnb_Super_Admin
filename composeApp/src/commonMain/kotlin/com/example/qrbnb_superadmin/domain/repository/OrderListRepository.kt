package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.OrderListData
import com.example.qrbnb_superadmin.domain.entity.OrdersListResponse

interface OrderListRepository {
    suspend fun getOrderList(
        clientId: String,
        status: String? = null,
    ): OrderListData
}
