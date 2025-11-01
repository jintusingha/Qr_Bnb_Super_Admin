package com.example.qrbnb_superadmin.presentation.screen.orders

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.OrderListSummary

import com.example.qrbnb_superadmin.ui.style_14_21_700

@Composable
fun StatusTabs(
    summary: OrderListSummary,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val tabs = listOf(
        "All" to (summary.new + summary.preparing + summary.ready + summary.delivered),
        "New" to summary.new,
        "Preparing" to summary.preparing,
        "Ready" to summary.ready,
        "Delivered" to summary.delivered,
    )

    ScrollableTabRow(
        selectedTabIndex = tabs.indexOfFirst { it.first == selectedTab }.coerceAtLeast(0),
        modifier = modifier.fillMaxWidth(),
        edgePadding = 16.dp,
        divider = {},
        containerColor = Color.Transparent,
    ) {
        tabs.forEach { (label, count) ->
            val selected = selectedTab == label
            val textColor = if (selected) Color(0xFF1C0D0D) else Color(0xFF9E474A)

            Tab(
                selected = selected,
                onClick = { onTabSelected(label) },
                text = {
                    Text(
                        text = "$label ($count)",
                        style = style_14_21_700(),
                        color = textColor,
                    )
                },
            )
        }
    }
}