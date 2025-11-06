package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight
import com.example.qrbnb_superadmin.ui.title_header_black
import com.example.qrbnb_superadmin.ui.title_reddish_brown

@Composable
fun OrderHeaderSection(
    id: String,
    date: String,
) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 12.dp)) {
        Text(
            text = "Order ID: #$id",
            style = style_18_23_w700(),
            color = title_header_black,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Created At: $date",
            style = textstyle_14_size_21_lineheight(),
            color = title_reddish_brown,
        )
    }
}
