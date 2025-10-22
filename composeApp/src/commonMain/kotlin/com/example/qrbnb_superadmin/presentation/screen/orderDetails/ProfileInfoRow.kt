package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight
import com.example.qrbnb_superadmin.ui.textstyle_16_size_24_lineheight
import com.example.qrbnb_superadmin.ui.title_header_black
import com.example.qrbnb_superadmin.ui.title_reddish_brown

@Composable
fun ProfileInfoRow(
    title: String,
    subtitle: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier.size(48.dp).padding(end = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = MaterialTheme.colorScheme.outline
            )
        }

        Column {
            Text(text = title, style = textstyle_16_size_24_lineheight(), color=title_header_black)
            Text(
                text = subtitle,
                style = textstyle_14_size_21_lineheight(),
                color = title_reddish_brown
            )
        }
    }
}