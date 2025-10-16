package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.TimelineEvent
import com.example.qrbnb_superadmin.ui.body16Regular
import com.example.qrbnb_superadmin.ui.calender_icon_tint_color
import com.example.qrbnb_superadmin.ui.date_text_color
import com.example.qrbnb_superadmin.ui.textstyle_16_size_21_lineheight
import org.jetbrains.compose.resources.painterResource
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.calender

@Composable
fun TimelineSection(timelineEvents: List<TimelineEvent>) {
    Column(modifier = Modifier.fillMaxWidth()) {

        timelineEvents.take(2).forEachIndexed { index, event ->
            DateLogItem(
                label = event.title,
                date = event.date,
                icon = Icons.Default.DateRange,
                description = event.description
            )
            if (index < timelineEvents.size - 1) {
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun DateLogItem(label: String, date: String, icon: ImageVector, description: String = "") {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.calender),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = calender_icon_tint_color
        )
        Spacer(Modifier.width(16.dp))

        Column {
            Text(
                text = label,
                style = textstyle_16_size_21_lineheight()
            )
            Text(
                text = date,
                style = body16Regular(),
                color = date_text_color
            )
        }
    }
}