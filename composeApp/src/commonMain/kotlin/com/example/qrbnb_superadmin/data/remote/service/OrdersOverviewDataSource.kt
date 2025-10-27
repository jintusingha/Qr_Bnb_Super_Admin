package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto

interface OrdersOverviewDataSource {
    suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto
}