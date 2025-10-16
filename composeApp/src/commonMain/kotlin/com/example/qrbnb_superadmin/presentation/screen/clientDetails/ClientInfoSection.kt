package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.ClientInfo
import com.example.qrbnb_superadmin.ui.client_info_email_phone_registrationdate_susbcription_status_color
import com.example.qrbnb_superadmin.ui.headline22Bold
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight



@Composable
fun InfoBlock(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

        Text(
            text = label,
            style = textstyle_14_size_21_lineheight(),
            color = client_info_email_phone_registrationdate_susbcription_status_color
        )

        Text(
            text = value,
            style =textstyle_14_size_21_lineheight())
    }
}



@Composable
fun InfoRow(
    label1: String,
    value1: String,
    label2: String,
    value2: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        InfoBlock(label = label1, value = value1, modifier = Modifier.weight(1f))


        InfoBlock(label = label2, value = value2, modifier = Modifier.weight(1f))
    }
}



@Composable
fun ClientInfoSection(client: ClientInfo) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Client Info",
            style = headline22Bold()
        )
        Spacer(Modifier.height(16.dp))


        InfoRow(
            label1 = "Email",
            value1 = client.email,
            label2 = "Phone",
            value2 = client.phone
        )
        Spacer(Modifier.height(16.dp))


        InfoRow(
            label1 = "Registration Date",
            value1 = client.registrationDate,
            label2 = "Subscription Status",
            value2 = client.subscriptionStatus
        )
    }
}

