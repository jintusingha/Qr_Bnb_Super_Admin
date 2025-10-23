package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.OrdersOverviewData

@Composable
fun DashboardContent(data: OrdersOverviewData) {
    // 1. Key Metrics Section
    OrderStatsSection(keyMetrics = data.summary)

    Spacer(Modifier.height(32.dp))

    // 2. Orders Over Time Section
    OrdersOverTimeSection(ordersTrend = data.ordersTrend)
//
    Spacer(Modifier.height(32.dp))
//
//    // 3. Client Performance Section
    ClientPerformanceSection(clientPerformance = data.clientPerformance)

    Spacer(Modifier.height(100.dp)) // Extra space for the floating action button
}