package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ActionDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientPerformanceDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.FiltersDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.GroupByOptionDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrderSummaryDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewDataDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersTrendDto
import com.example.qrbnb_superadmin.domain.entity.*

// ==========================
// HELPER ENUM MAPPER
// ==========================
fun String.toTrendEnum(): Trend {
    return when (this.lowercase()) {
        "up" -> Trend.UP
        "down" -> Trend.DOWN
        else -> Trend.FLAT
    }
}

// ==========================
// DTO -> DOMAIN MAPPERS
// ==========================

fun OrdersOverviewResponseDto.toDomain(): OrdersOverview {
    return OrdersOverview(
        success = this.success,
        data = this.data.toDomain()
    )
}

fun OrdersOverviewDataDto.toDomain(): OrdersOverviewData {
    return OrdersOverviewData(
        summary = this.summary.toDomain(),
        ordersTrend = this.ordersTrend.toDomain(),
        filters = this.filters.toDomain(),
        clientPerformance = this.clientPerformance.toDomain(),
        actions = this.actions.map { it.toDomain() }
    )
}

fun OrderSummaryDto.toDomain(): OrderSummary {
    return OrderSummary(
        totalOrders = this.totalOrders,
        totalRevenue = this.totalRevenue,
        activeClients = this.activeClients,
        topSellingCategory = this.topSellingCategory
    )
}

fun ClientDto.toDomain(): Client_details {
    return Client_details(
        id = this.id,
        name = this.name,
        avatarUrl = this.avatarUrl,
        ordersCount = this.ordersCount,
        lastOrderAgo = this.lastOrderAgo,
        totalRevenue = this.revenue // Correct mapping
    )
}

fun GroupByOptionDto.toDomain(): GroupByOption {
    return GroupByOption(
        id = this.id,
        label = this.label
    )
}

fun ActionDto.toDomain(): Action {
    return Action(
        label = this.label,
        icon = this.icon,
        destinationEndpoint = this.endpoint
    )
}

fun OrdersTrendDto.toDomain(): OrdersTrend {
    return OrdersTrend(
        label = this.label,
        percentageChange = this.comparison.percentageChange,
        trend = this.comparison.trend.toTrendEnum(),
        xAxis = this.chart.xAxis,
        yAxis = this.chart.yAxis
    )
}

fun FiltersDto.toDomain(): Filters {
    return Filters(
        timeframe = this.timeframe,
        groupBy = this.groupBy.map { it.toDomain() },
        defaultGroupBy = this.defaultGroupBy
    )
}

fun ClientPerformanceDto.toDomain(): ClientPerformance {
    return ClientPerformance(
        sortOptions = this.sortOptions,
        defaultSort = this.defaultSort,
        clients = this.clients.map { it.toDomain() }
    )
}
