package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrbnb_superadmin.domain.entity.OrdersTrend
import com.example.qrbnb_superadmin.ui.style_13_20_700

@Composable
fun OrdersOverTimeSection(
    ordersTrend: OrdersTrend,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Orders Over Time",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Text(
                text = "(${ordersTrend.period})",
                fontSize = 14.sp,
                color = Color.Gray,
            )
        }

        Spacer(Modifier.height(8.dp))

        val growthColor = if (ordersTrend.growthPercent >= 0) Color(0xFF4CAF50) else Color(0xFFF44336)
        val growthSign = if (ordersTrend.growthPercent >= 0) "+" else ""
        Text(
            text = "Growth: $growthSign${ordersTrend.growthPercent}%",
            color = growthColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 16.dp),
        )

        Spacer(Modifier.height(16.dp))

        val data = ordersTrend.trendData.map { it.orders.toFloat() }
        val labels = ordersTrend.trendData.map { it.month }

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 16.dp),
            //                .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
//                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Canvas(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                val width = size.width
                val height = size.height
                val max = data.maxOrNull() ?: 1f
                val spacing = width / (data.size - 1)

                val path = Path()
                data.forEachIndexed { index, value ->
                    val x = index * spacing
                    val y = height - (value / max * height)
                    if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
                }

                drawPath(path, Color(0xFF8C5E5E), style = Stroke(3.dp.toPx()))
            }
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            labels.forEach {
                Text(
                    text = it,
                    style = style_13_20_700(),
                    color = Color(0xFF8C5E5E),
                )
            }
        }
    }
}
