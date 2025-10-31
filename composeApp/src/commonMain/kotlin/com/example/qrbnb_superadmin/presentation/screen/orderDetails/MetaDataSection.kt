package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.Metadata

import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import com.example.qrbnb_superadmin.ui.title_header_black

@Composable
fun MetadataSection(metadata: Metadata) {
    Text(
        text = "Metadata",
        style = style_16_24_w500(),
        color = title_header_black
    )

    Column(modifier = Modifier.fillMaxWidth().padding(top = 4.dp)) {
        MetadataItem(label = "Created by", value = metadata.creator)
        MetadataItem(label = "Payment Method", value = metadata.paymentMethod)
        MetadataItem(label = "Platform", value = metadata.platform)
    }
}
