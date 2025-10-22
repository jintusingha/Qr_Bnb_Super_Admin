package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.Item
import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight
import com.example.qrbnb_superadmin.ui.textstyle_16_size_24_lineheight
import com.example.qrbnb_superadmin.ui.title_header_black
import com.example.qrbnb_superadmin.ui.title_reddish_brown

@Composable
 fun ItemRow(item: Item, currency: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.name, style = style_16_24_w500(), color = title_header_black)
            Text(text = "Qty: ${item.quantity}", style = textstyle_14_size_21_lineheight(), color = title_reddish_brown)
            Text(
                text = item.notes,
                style = textstyle_14_size_21_lineheight(),
                color = title_reddish_brown
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "${currency} %.2f".format(item.itemTotal),
                style = textstyle_16_size_24_lineheight()
            )
            Text(
                text = "${currency} %.2f Each".format(item.unitPrice),
                style = textstyle_14_size_21_lineheight(),
                color = title_reddish_brown
            )
        }
    }
}