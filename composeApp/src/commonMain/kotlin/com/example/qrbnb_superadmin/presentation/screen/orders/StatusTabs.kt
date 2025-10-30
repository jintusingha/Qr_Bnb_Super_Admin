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
import com.example.qrbnb_superadmin.domain.entity.OrderStatusSummary
import com.example.qrbnb_superadmin.ui.style_14_21_700

@Composable
fun StatusTabs(
    statusSummary: List<OrderStatusSummary>,
    modifier: Modifier = Modifier,
) {
    ScrollableTabRow(
        selectedTabIndex = statusSummary.indexOfFirst { it.isCurrentSelection }.coerceAtLeast(0),
        modifier = modifier.fillMaxWidth(),
        edgePadding = 16.dp,
        divider = {},
        containerColor = Color.Transparent,
    ) {
        statusSummary.forEach { summary ->
            val textColor =
                if (summary.isCurrentSelection) {
                    Color(0xFF1C0D0D)
                } else {
                    Color(0xFF9E474A)
                }

            Tab(
                selected = summary.isCurrentSelection,
                onClick = { /* TODO: Handle tab click */ },
                text = {
                    Text(
                        text = "${summary.status.name.lowercase().replaceFirstChar { it.uppercase() }} (${summary.count})",
                        style = style_14_21_700(),
                        color = textColor,
                    )
                },
            )
        }
    }
}
