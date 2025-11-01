package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.OrderListDataSource
import com.example.qrbnb_superadmin.domain.entity.OrdersResponse
import com.example.qrbnb_superadmin.domain.repository.OrderListRepository


class OrdersRepositoryImpl (private val datasource: OrderListDataSource): OrderListRepository {
    override suspend fun getDetails(): OrdersResponse {
        val response=datasource.getOrdersData()
        return response.toDomain()


    }
}