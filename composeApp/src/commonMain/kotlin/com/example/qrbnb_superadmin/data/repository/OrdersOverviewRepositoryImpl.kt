package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.OrdersOverviewDataSource
import com.example.qrbnb_superadmin.domain.entity.OrdersOverview
import com.example.qrbnb_superadmin.domain.repository.OrdersOverviewRepository

class OrdersOverviewRepositoryImpl(
    private val dataSource: OrdersOverviewDataSource,
) : OrdersOverviewRepository {
    override suspend fun getOrdersOverview(): OrdersOverview {
        val dtoResponse = dataSource.getOrdersOverviewData()

        return dtoResponse.toDomain()
    }
}
