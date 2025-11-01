package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.OrdersOverviewData

@Composable
fun DashboardContent(data: OrdersOverviewData, onClientClick: (String) -> Unit) {
    OrderStatsSection(keyMetrics = data.summary)

    Spacer(Modifier.height(32.dp))

    OrdersOverTimeSection(ordersTrend = data.ordersTrend)

    Spacer(Modifier.height(32.dp))

    ClientPerformanceSection(clientPerformance = data.clientPerformance,onClientClick = onClientClick)

    Spacer(Modifier.height(100.dp))
}
