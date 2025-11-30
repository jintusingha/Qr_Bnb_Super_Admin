package com.example.qrbnb_superadmin.presentation.screen.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.qrbnb_superadmin.domain.entity.OrderListItem
import com.example.qrbnb_superadmin.ui.Black_color
import com.example.qrbnb_superadmin.ui.soft_reddish
import com.example.qrbnb_superadmin.ui.style_14_21_400
import com.example.qrbnb_superadmin.ui.style_14_21_400_Orders_screen
import com.example.qrbnb_superadmin.ui.style_14_21_500
import com.example.qrbnb_superadmin.ui.style_16_20_700

@Composable
fun OrderCard(
    order: OrderListItem,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {
    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable { onClick(order.orderId) },
        shape = RoundedCornerShape(12.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = Color.White,
            ),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Order #${order.orderId}",
                    style = style_14_21_400(),
                    color = soft_reddish,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${order.timeAgo} • ${order.seatingArea?.name ?: "Unknown"}",
                    style = style_16_20_700(),
                    color = Black_color,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Guest: ${order.guest.name} • ${order.items.summary.take(n=5)}",
                    style = style_14_21_400(),
                    color = soft_reddish,

                )
                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { /* Handle accept */ },
                    shape = RoundedCornerShape(12.dp),
                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFCE4EC),
                            contentColor = Black_color,
                        ),
                    modifier =
                        Modifier
                            .width(96.dp)
                            .height(32.dp)
                            .graphicsLayer(
                                rotationZ = 0f,
                                alpha = 1f,
                            ),
                    contentPadding = PaddingValues(start = 16.dp, end = 8.dp, top = 0.dp, bottom = 0.dp),
                ) {
                    Text(
                        text = "Accept",
                        style = style_14_21_500(),
                        color = Black_color,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Black_color,
                        modifier = Modifier.size(16.dp),
                    )
                }
            }

            AsyncImage(
                model = order.thumbnail,
                contentDescription = "Order image",
                modifier =
                    Modifier
                        .width(130.dp)
                        .height(130.dp)
                        .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
            )
        }
    }
}
