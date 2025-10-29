package com.example.qrbnb_superadmin.presentation.screen.ordersOverview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.input.pointer.stylusHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.qrbnb_superadmin.domain.entity.ClientPerformance
import com.example.qrbnb_superadmin.ui.body16Regular
import com.example.qrbnb_superadmin.ui.search_field_color
import com.example.qrbnb_superadmin.ui.search_icon_placeholdertext
import com.example.qrbnb_superadmin.ui.sortBackground
import com.example.qrbnb_superadmin.ui.style_14_21_400
import com.example.qrbnb_superadmin.ui.style_14_21_500
import com.example.qrbnb_superadmin.ui.style_16_24_w500
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import com.example.qrbnb_superadmin.ui.title_reddish_brown
import org.jetbrains.compose.resources.painterResource
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.searchicon

@Composable
fun ClientPerformanceSection(
    clientPerformance: List<ClientPerformance>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Client Performance",
            style = style_18_23_w700(),
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.searchicon),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp),
                    tint = search_icon_placeholdertext,
                )
            },
            placeholder = {
                Text(
                    "Search clients",
                    style = body16Regular(),
                    color = search_icon_placeholdertext,
                    modifier = Modifier.padding(bottom = 2.dp),
                )
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors =
                OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = search_field_color,
                    focusedContainerColor = search_field_color,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                ),
        )
        Spacer(Modifier.height(16.dp))

        // --- Sort Header ---
//        Box(
//            modifier = Modifier
//                .padding(start = 16.dp)
//                .background(
//                    color = sortBackground,
//                    shape = RoundedCornerShape(50)
//                )
//                .padding(horizontal = 12.dp, vertical = 6.dp) // inner padding for text
//        ) {
//            Text(
//                text = "Sort by: ${clientPerformance.defaultSort}",
//                style = style_14_21_500(),
//                color = Color.Black
//            )
//        }

        Spacer(Modifier.height(8.dp))

        // --- Client List ---
        Column(modifier = Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            clientPerformance.forEach { client ->
                ClientListItem(client = client)
            }
        }
    }
}

@Composable
fun ClientListItem(client: ClientPerformance) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier =
                Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center,
        ) {
            if (client.avatar.isNotEmpty()) {
                AsyncImage(
                    model = client.avatar,
                    contentDescription = "Client Avatar: ${client.name}",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            } else {
                Text(
                    text =
                        client.name
                            .firstOrNull()
                            ?.toString()
                            ?.uppercase() ?: "C",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }
        }

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = client.name,
                style = style_16_24_w500(),
                color = Color(0xFF1C1C1C),
            )

            Text(
                text = "Orders: ${client.orders}",
                style = style_14_21_400(),
                color = title_reddish_brown,
            )

            Text(
                text = "Last Order: ${client.lastOrderAgo}",
                style = style_14_21_400(),
                color = title_reddish_brown,
            )
        }

        Text(
            text = "$${client.revenue}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF1C1C1C),
        )
    }
}
