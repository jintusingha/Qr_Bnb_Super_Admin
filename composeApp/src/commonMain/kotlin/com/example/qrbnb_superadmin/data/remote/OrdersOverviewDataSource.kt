package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.ordersoverviewDto.OrdersOverviewResponseDto

interface OrdersOverviewDataSource {
    suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto
}
