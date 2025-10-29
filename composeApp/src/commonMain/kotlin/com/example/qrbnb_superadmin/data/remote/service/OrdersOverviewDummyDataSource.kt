package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientPerformanceDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrderSummaryDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewDataDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersTrendDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.TrendDataDto

class OrdersOverviewDummyDataSource : OrdersOverviewDataSource {
    override suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto {
        val summaryDto = OrderSummaryDto(
            totalOrders = 1985,
            totalRevenue = 5319,
            activeClients = 498,
            topCategory = "Grocery"
        )

        val trendPoints = listOf(
            TrendDataDto(month = "Jan", orders = 242),
            TrendDataDto(month = "Feb", orders = 277),
            TrendDataDto(month = "Mar", orders = 287),
            TrendDataDto(month = "Apr", orders = 261),
            TrendDataDto(month = "May", orders = 388),
            TrendDataDto(month = "Jun", orders = 315)
        )

        val ordersTrendDto = OrdersTrendDto(
            period = "6m",
            growthPercent = +20,
            trendData = trendPoints
        )

        val clientPerformanceList = listOf(
            ClientPerformanceDto(
                id = "2b8a5cd0-d329-48a2-b4e7-0d8002b4b51e",
                name = "Sophia",
                avatar = "https://api.dicebear.com/7.x/adventurer/svg?seed=Sophia",
                orders = 11,
                revenue = 195,
                lastOrderAgo = "2h"
            ),
            ClientPerformanceDto(
                id = "2e263732-7687-4b1a-9b61-a2cd8a76b238",
                name = "Ethan",
                avatar = "https://api.dicebear.com/7.x/adventurer/svg?seed=Ethan",
                orders = 12,
                revenue = 141,
                lastOrderAgo = "4h"
            ),
            ClientPerformanceDto(
                id = "dd2c0c4e-7272-406e-a173-10676f428e54",
                name = "Olivia",
                avatar = "https://api.dicebear.com/7.x/adventurer/svg?seed=Olivia",
                orders = 12,
                revenue = 127,
                lastOrderAgo = "4h"
            )
        )

        val dataDto = OrdersOverviewDataDto(
            summary = summaryDto,
            ordersTrend = ordersTrendDto,
            clientPerformance = clientPerformanceList
        )

        return OrdersOverviewResponseDto(
            success = true,
            message = "Mock Orders Overview (staging/local)",
            data = dataDto
        )
    }
}
