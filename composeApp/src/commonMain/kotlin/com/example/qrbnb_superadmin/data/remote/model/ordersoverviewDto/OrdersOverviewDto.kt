package com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto

import kotlinx.serialization.Serializable

@Serializable
data class OrderSummaryDto(
    val totalOrders: Int,
    val totalRevenue: Int,
    val activeClients: Int,
    val topCategory: String,
)

@Serializable
data class TrendDataDto(
    val month: String,
    val orders: Int,
)

@Serializable
data class OrdersTrendDto(
    val period: String,
    val growthPercent: Int,
    val trendData: List<TrendDataDto>,
)

@Serializable
data class ClientPerformanceDto(
    val id: String,
    val name: String,
    val avatar: String,
    val orders: Int,
    val revenue: Int,
    val lastOrderAgo: String,
)

@Serializable
data class OrdersOverviewDataDto(
    val summary: OrderSummaryDto,
    val ordersTrend: OrdersTrendDto,
    val clientPerformance: List<ClientPerformanceDto>,
)

@Serializable
data class OrdersOverviewResponseDto(
    val success: Boolean,
    val message: String,
    val data: OrdersOverviewDataDto,
)
