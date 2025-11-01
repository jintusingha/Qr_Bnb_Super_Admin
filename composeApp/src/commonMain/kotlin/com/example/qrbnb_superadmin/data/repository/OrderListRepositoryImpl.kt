package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.data.mapper.toDomain
import com.example.qrbnb_superadmin.data.remote.service.OrderListDataSource
import com.example.qrbnb_superadmin.domain.entity.OrderListData
import com.example.qrbnb_superadmin.domain.entity.OrdersListResponse

import com.example.qrbnb_superadmin.domain.repository.OrderListRepository


class OrderListRepositoryImpl (private val datasource: OrderListDataSource): OrderListRepository {
    override suspend fun getOrderList(
        clientId: String,
        status: String?
    ): OrderListData {
        val response=datasource.getOrderListData(clientId,status)
        return response.data.toDomain()

    }

}