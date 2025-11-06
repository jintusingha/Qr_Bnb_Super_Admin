package com.example.qrbnb_superadmin.presentation.screen.clientoverview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.presentation.state.ClientsOverviewState
import com.example.qrbnb_superadmin.ui.client_id_style
import com.example.qrbnb_superadmin.ui.client_id_text_color
import com.example.qrbnb_superadmin.ui.client_list_text_style

@Composable
fun ClientListItem(
    client: Client,
    onClick: (clientId: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItem(
        modifier =
            modifier
                .clickable { onClick(client.id) },
        colors =
            ListItemDefaults.colors(
                containerColor = Color.White,
            ),
        headlineContent = {
            Text(
                text = "Client Name: ${client.name}",
                style = client_list_text_style(),
                fontWeight = FontWeight.SemiBold,
            )
        },
        supportingContent = {
            val shortId =
                if (client.id.length > 6) {
                    client.id.takeLast(6)
                } else {
                    client.id
                }

            Text(
                text = "Client ID: $shortId",
                style = client_id_style(),
                color = client_id_text_color,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        trailingContent = {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Details")
        },
    )
}
