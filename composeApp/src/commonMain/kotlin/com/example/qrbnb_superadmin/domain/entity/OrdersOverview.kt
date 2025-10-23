package com.example.qrbnb_superadmin.domain.entity

// ENUM for trend safety
enum class Trend {
    UP, DOWN, FLAT
}

// ========== DATA MODELS (The clean entities used by the app) ==========

data class OrderSummary(
    val totalOrders: Int,
    val totalRevenue: Int,
    val activeClients: Int,
    val topSellingCategory: String
)

data class Client_details(
    val id: String,
    val name: String,
    val avatarUrl: String,
    val ordersCount: Int,
    val lastOrderAgo: String,
    val totalRevenue: Int // Renamed 'revenue' to 'totalRevenue' for clarity
)

data class GroupByOption(
    val id: String,
    val label: String
)

// Simplified Action for the Domain Layer
data class Action(
    val label: String,
    val icon: String,
    val destinationEndpoint: String // Only keep fields needed for UI action
)

data class OrdersTrend(
    val label: String,
    val percentageChange: Int,
    val trend: Trend, // Using the safe Enum
    val xAxis: List<String>,
    val yAxis: List<Int>
)

data class Filters(
    val timeframe: List<String>,
    val groupBy: List<GroupByOption>,
    val defaultGroupBy: String
)

data class ClientPerformance(
    val sortOptions: List<String>,
    val defaultSort: String,
    val clients: List<Client_details>
)

data class OrdersOverviewData(
    val summary: OrderSummary,
    val ordersTrend: OrdersTrend,
    val filters: Filters,
    val clientPerformance: ClientPerformance,
    val actions: List<Action>
)

data class OrdersOverview(
    val success: Boolean,
    val data: OrdersOverviewData
)