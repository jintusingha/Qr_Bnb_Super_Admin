package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ordersDto.OrderScreenData


interface OrdersDataSource{
    suspend fun getOrdersData(): OrderScreenData
}