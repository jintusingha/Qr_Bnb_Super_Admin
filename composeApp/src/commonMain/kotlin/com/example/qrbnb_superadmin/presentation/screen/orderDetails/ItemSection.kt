package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.runtime.Composable
import com.example.qrbnb_superadmin.domain.entity.Item
import com.example.qrbnb_superadmin.ui.style_18_23_w700

@Composable fun ItemsSection(items: List<Item>, currency: String) {
    SectionTitle(title = "Items")
    items.forEach { item ->
        ItemRow(item = item, currency = currency)
    }
}