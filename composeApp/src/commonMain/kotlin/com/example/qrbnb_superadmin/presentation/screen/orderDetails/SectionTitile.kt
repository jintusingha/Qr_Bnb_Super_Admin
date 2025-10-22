package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.style_18_23_w700

@Composable
 fun SectionTitle(title: String, ) {
    Text(
        text = title,
        style = style_18_23_w700(),

        modifier = Modifier.padding(bottom = 8.dp)
    )
}