package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientInfo
import com.example.qrbnb_superadmin.ui.body16Regular
import com.example.qrbnb_superadmin.ui.client_Name
import com.example.qrbnb_superadmin.ui.client_email_text_color

@Composable
fun ClientHeader(client: ClientInfo, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ClientAvatar(

            avatarUrl = client.avatarUrl
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = client.name,
            style = client_Name()
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = client.email,
            style = body16Regular(),
            color = client_email_text_color
        )
    }
}