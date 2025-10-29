package com.example.qrbnb_superadmin.data.mapper


import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientPerformanceDto

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrderSummaryDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewDataDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersTrendDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.TrendDataDto
import com.example.qrbnb_superadmin.domain.entity.*

// ==========================
// HELPER ENUM MAPPER
// ==========================

// ==========================
// DTO -> DOMAIN MAPPERS
// ==========================

// Top-level mapper
fun OrdersOverviewResponseDto.toDomain(): OrdersOverview {
    return OrdersOverview(
        success = success,
        message = message,
        data = data.toDomain()
    )
}

// "data" object mapper
fun OrdersOverviewDataDto.toDomain(): OrdersOverviewData {
    return OrdersOverviewData(
        summary = summary.toDomain(),
        ordersTrend = ordersTrend.toDomain(),
        clientPerformance = clientPerformance.map { it.toDomain() }
    )
}

// Summary mapper
fun OrderSummaryDto.toDomain(): Summary {
    return Summary(
        totalOrders = totalOrders,
        totalRevenue = totalRevenue,
        activeClients = activeClients,
        topCategory = topCategory
    )
}

// Orders trend section
fun OrdersTrendDto.toDomain(): OrdersTrend {
    return OrdersTrend(
        period = period,
        growthPercent = growthPercent,
        trendData = trendData.map { it.toDomain() }
    )
}

// Each trend data point
fun TrendDataDto.toDomain(): TrendData {
    return TrendData(
        month = month,
        orders = orders
    )
}

// Each client performance entry
fun ClientPerformanceDto.toDomain(): ClientPerformance {
    return ClientPerformance(
        id = id,
        name = name,
        avatar = avatar,
        orders = orders,
        revenue = revenue,
        lastOrderAgo = lastOrderAgo
    )
}