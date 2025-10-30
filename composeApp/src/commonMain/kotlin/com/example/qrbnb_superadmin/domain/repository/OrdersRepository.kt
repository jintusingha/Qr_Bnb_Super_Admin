package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.OrdersResponse

interface OrdersRepository{
    suspend fun getDetails(): OrdersResponse
}