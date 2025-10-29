package com.example.qrbnb_superadmin.domain.entity

data class Summary(
    val totalOrders: Int,
    val totalRevenue: Int,
    val activeClients: Int,
    val topCategory: String,
)

data class ClientPerformance(
    val id: String,
    val name: String,
    val avatar: String,
    val orders: Int,
    val revenue: Int,
    val lastOrderAgo: String,
)

data class TrendData(
    val month: String,
    val orders: Int,
)

data class OrdersTrend(
    val period: String,
    val growthPercent: Int,
    val trendData: List<TrendData>,
)

data class OrdersOverviewData(
    val summary: Summary,
    val ordersTrend: OrdersTrend,
    val clientPerformance: List<ClientPerformance>,
)

data class OrdersOverview(
    val success: Boolean,
    val message: String,
    val data: OrdersOverviewData,
)
