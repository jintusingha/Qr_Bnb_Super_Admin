package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.qrbnb_superadmin.ui.jakarta_regular_14px


@Composable
fun PanelFooterText() {
    Text(
        text = "QRBnb Superadmin Panel",
        style = jakarta_regular_14px(),
        color = Color.Gray
    )
}