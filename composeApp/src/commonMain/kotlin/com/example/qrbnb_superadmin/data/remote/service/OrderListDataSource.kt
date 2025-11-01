package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderListResponseDto



interface OrderListDataSource{
    suspend fun getOrderListData(clientId:String,status:String?=null): OrderListResponseDto
}