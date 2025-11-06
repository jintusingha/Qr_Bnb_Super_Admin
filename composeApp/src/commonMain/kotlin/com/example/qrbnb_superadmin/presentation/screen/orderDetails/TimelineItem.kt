package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight
import com.example.qrbnb_superadmin.ui.title_reddish_brown

@Composable
fun TimelineItem(
    status: String,
    time: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 17.dp),
    ) {
        Text(
            text = status,
            style = textstyle_14_size_21_lineheight(),
            color = title_reddish_brown,
        )
        Text(
            text = time,
            style = textstyle_14_size_21_lineheight(),
            color = title_reddish_brown,
        )
    }
}
