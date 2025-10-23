package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.OrdersOverview

interface OrdersOverviewRepository {
    suspend fun getOrdersOverview(): OrdersOverview
}
