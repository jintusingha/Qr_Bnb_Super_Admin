package com.example.qrbnb_superadmin.data.remote.ordersoverviewDto

import kotlinx.serialization.Serializable


@Serializable
data class OrderSummaryDto(
    val totalOrders: Int,
    val totalRevenue: Int,
    val activeClients: Int,
    val topSellingCategory: String
)

@Serializable
data class ClientDto(
    val id: String,
    val name: String,
    val avatarUrl: String,
    val ordersCount: Int,
    val lastOrderAgo: String,
    val revenue: Int
)

@Serializable
data class GroupByOptionDto(
    val id: String,
    val label: String
)

@Serializable
data class ActionDto(
    val id: String,
    val label: String,
    val icon: String,
    val type: String,
    val endpoint: String,
    val method: String
)


@Serializable
data class TrendComparisonDto(
    val period: String,
    val percentageChange: Int,
    val trend: String
)

@Serializable
data class ChartDataDto(
    val xAxis: List<String>,
    val yAxis: List<Int>
)

@Serializable
data class OrdersTrendDto(
    val label: String,
    val comparison: TrendComparisonDto,
    val chart: ChartDataDto
)

@Serializable
data class FiltersDto(
    val timeframe: List<String>,
    val groupBy: List<GroupByOptionDto>,
    val defaultGroupBy: String
)

@Serializable
data class ClientPerformanceDto(
    val sortOptions: List<String>,
    val defaultSort: String,
    val clients: List<ClientDto>
)


@Serializable
data class OrdersOverviewDataDto(
    val summary: OrderSummaryDto,
    val ordersTrend: OrdersTrendDto,
    val filters: FiltersDto,
    val clientPerformance: ClientPerformanceDto,
    val actions: List<ActionDto>
)


@Serializable
data class OrdersOverviewResponseDto( // Renamed to clearly be the full API response DTO
    val success: Boolean,
    val data: OrdersOverviewDataDto
)