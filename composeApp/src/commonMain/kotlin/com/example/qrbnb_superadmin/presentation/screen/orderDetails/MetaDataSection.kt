package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.qrbnb_superadmin.domain.entity.MetadataPair
import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import com.example.qrbnb_superadmin.ui.title_header_black

@Composable
fun MetadataSection(metadata: List<MetadataPair>) {
//    SectionTitle(title = "Metadata", )
    Text("Metadata", style = style_16_24_w500(), color = title_header_black)

    metadata.forEach { pair ->
        MetadataItem(label = pair.label, value = pair.value)
    }
}
