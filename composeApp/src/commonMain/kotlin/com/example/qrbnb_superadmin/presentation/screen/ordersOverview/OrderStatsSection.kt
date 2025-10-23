package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.OrderSummary

import com.example.qrbnb_superadmin.presentation.screen.clientoverview.StatCard

@Composable
fun OrderStatsSection(keyMetrics: OrderSummary, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        // Row 1: Total Orders and Total Revenue
        Row(
            // Use IntrinsicSize.Min to ensure both cards share the same height as the tallest card
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard(
                title = "Total Orders",
                value = keyMetrics.totalOrders.toString(),
                modifier = Modifier.weight(1f).fillMaxHeight() // Fill height of the Row
            )
            StatCard(
                title = "Total Revenue",
                value = "$${keyMetrics.totalRevenue}", // Format with dollar sign
                modifier = Modifier.weight(1f).fillMaxHeight() // Fill height of the Row
            )
        }

        Spacer(Modifier.height(16.dp))

        // Row 2: Active Clients and Top-Selling Category
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard(
                title = "Active Clients",
                value = keyMetrics.activeClients.toString(),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            StatCard(
                title = "Top-Selling Category",
                value = keyMetrics.topSellingCategory,
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
    }
}