package com.example.qrbnb_superadmin.presentation.screen.orderDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.qrbnb_superadmin.domain.entity.TimelineEventOrderDetails
import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import com.example.qrbnb_superadmin.ui.title_header_black

@Composable
 fun OrderStatusTimeline(events: List<TimelineEventOrderDetails>) {
     Text("Order Status Timeline", style = style_16_24_w500(),  color = title_header_black)
//    SectionTitle(title = "Order Status Timeline")

    Column(modifier = Modifier.fillMaxWidth()) {
        events.forEach { event->
            TimelineItem(status = event.status, time = event.time)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}


