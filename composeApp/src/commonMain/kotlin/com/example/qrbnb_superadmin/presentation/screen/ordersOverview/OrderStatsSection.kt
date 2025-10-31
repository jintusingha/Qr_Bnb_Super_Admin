package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import StatCard
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

import com.example.qrbnb_superadmin.domain.entity.Summary




@Composable
fun OrderStatsSection(keyMetrics: Summary, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {

        Row(

            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard(
                title = "Total Orders",
                value = keyMetrics.totalOrders.toString(),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            StatCard(
                title = "Total Revenue",
                value = "$${keyMetrics.totalRevenue}",
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }

        Spacer(Modifier.height(16.dp))


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
                value = keyMetrics.topCategory,
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
    }
}