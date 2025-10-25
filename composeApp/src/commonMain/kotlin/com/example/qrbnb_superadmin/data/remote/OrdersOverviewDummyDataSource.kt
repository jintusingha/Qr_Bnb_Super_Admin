package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ActionDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ChartDataDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.ClientPerformanceDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.FiltersDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.GroupByOptionDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrderSummaryDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewDataDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersTrendDto
import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.TrendComparisonDto

class OrdersOverviewDummyDataSource : OrdersOverviewDataSource {
    override suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto {
        val summaryDto =
            OrderSummaryDto(
                totalOrders = 1234,
                totalRevenue = 5678,
                activeClients = 345,
                topSellingCategory = "Coffee",
            )

        val trendComparisonDto =
            TrendComparisonDto(
                period = "Last 30 Days",
                percentageChange = 12,
                trend = "up",
            )

        val chartDataDto =
            ChartDataDto(
                xAxis = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun"),
                yAxis = listOf(200, 230, 260, 220, 290, 270),
            )

        val ordersTrendDto =
            OrdersTrendDto(
                label = "Orders Over Time",
                comparison = trendComparisonDto,
                chart = chartDataDto,
            )

        val clientDtos =
            listOf(
                ClientDto(
                    id = "c_001",
                    name = "Sophia",
                    avatarUrl = "https://cdn.qrbnb.io/avatars/sophia.png",
                    ordersCount = 12,
                    lastOrderAgo = "2h ago",
                    revenue = 120,
                ),
                ClientDto(
                    id = "c_002",
                    name = "Ethan",
                    avatarUrl = "https://cdn.qrbnb.io/avatars/ethan.png",
                    ordersCount = 8,
                    lastOrderAgo = "3h ago",
                    revenue = 80,
                ),
                ClientDto(
                    id = "c_003",
                    name = "Olivia",
                    avatarUrl = "https://cdn.qrbnb.io/avatars/olivia.png",
                    ordersCount = 15,
                    lastOrderAgo = "1h ago",
                    revenue = 150,
                ),
            )

        val clientPerformanceDto =
            ClientPerformanceDto(
                sortOptions = listOf("Revenue", "Orders", "Last Order"),
                defaultSort = "Revenue",
                clients = clientDtos,
            )

        val dataDto =
            OrdersOverviewDataDto(
                summary = summaryDto,
                ordersTrend = ordersTrendDto,
                filters =
                    FiltersDto(
                        timeframe = listOf("Last 7 Days", "Last 30 Days", "Last 90 Days"),
                        groupBy =
                            listOf(
                                GroupByOptionDto(id = "client", label = "Client"),
                                GroupByOptionDto(id = "category", label = "Category"),
                                GroupByOptionDto(id = "item", label = "Item"),
                            ),
                        defaultGroupBy = "client",
                    ),
                clientPerformance = clientPerformanceDto,
                actions =
                    listOf(
                        ActionDto(
                            id = "addOrder",
                            label = "Add New Order",
                            icon = "plus",
                            type = "button",
                            endpoint = "/api/superadmin/orders/new",
                            method = "GET",
                        ),
                    ),
            )

        return OrdersOverviewResponseDto(success = true, data = dataDto)
    }
}
