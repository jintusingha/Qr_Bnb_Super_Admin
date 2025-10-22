package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.OrderDetails

@Composable
fun TotalsSummary(details: OrderDetails) {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp), // 👈 adds equal space between each row
        modifier = Modifier.fillMaxWidth()
    ) {
        SummaryRow(label = "Subtotal", value = details.subtotal, currency = details.currency)
        SummaryRow(label = "Taxes", value = details.tax, currency = details.currency)
        TotalRow(label = "Total", value = details.total, currency = details.currency)
        Spacer(modifier = Modifier.height(4.dp))
    }
}