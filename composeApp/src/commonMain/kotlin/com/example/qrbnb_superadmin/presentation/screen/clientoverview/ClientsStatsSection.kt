package com.example.qrbnb_superadmin.presentation.screen.clientoverview

import StatCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.ClientOverview

@Composable
fun ClientsStatsSection(
    overview: ClientOverview?,
    onTotalClientsClick:()->Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                title = "Total Clients",
                value = overview?.totalClients.toString(),
                modifier = Modifier.weight(1f),
                onClick = onTotalClientsClick

            )
            StatCard(
                title = "Total Menus Live",
                value = overview?.totalMenusLive.toString(),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(8.dp))


        StatCard(
            title = "Active Subscriptions",
            value = overview?.activeSubscriptions.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}