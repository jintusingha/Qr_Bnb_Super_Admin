package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.style_16_24_w400
import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.textstyle_16_size_24_lineheight

@Composable
 fun SummaryRow(label: String, value: Double, currency: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = style_16_24_w400())
        Text(
//            text = currency + "%.2f".format(value),
            text="${currency} %.2f".format(value),
            style = style_16_24_w500()
        )
    }
}

