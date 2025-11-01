package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderScreenData


interface OrderListDataSource{
    suspend fun getOrdersData(): OrderScreenData
}