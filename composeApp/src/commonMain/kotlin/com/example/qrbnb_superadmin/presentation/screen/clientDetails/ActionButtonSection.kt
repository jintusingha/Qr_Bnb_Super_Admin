package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.ClientAction
import com.example.qrbnb_superadmin.presentation.reusable_composables.PrimaryActionButton
import com.example.qrbnb_superadmin.ui.client_details_activate_delete_export_client_data_text_color
import com.example.qrbnb_superadmin.ui.client_details_btn_color


@Composable
fun ActionButtonsSection(actions: List<ClientAction>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        actions.forEach { clientAction ->
            Spacer(Modifier.height(16.dp))

            when (clientAction.action) {


                "ACTIVATE" -> PrimaryActionButton(
                    text = clientAction.label,
                    onClick = { /* Handle Activate click */ },
                    backgroundColor = Color.Red,
                    textColor = Color.White
                )


                "DELETE" -> PrimaryActionButton(
                    text = clientAction.label,
                    onClick = { /* Handle Delete */ },
                    backgroundColor = Color.Red,
                    textColor = Color.White


                )


                "EXPORT" -> PrimaryActionButton(
                    text = clientAction.label,
                    onClick = { /* Handle Export */ },
                    backgroundColor = Color.Red,
                    textColor = Color.White

                )


                else -> PrimaryActionButton(
                    text = clientAction.label,
                    onClick = { /* Handle Generic click */ },
                    backgroundColor = client_details_btn_color,
                    textColor = client_details_activate_delete_export_client_data_text_color
                )
            }
        }
    }
}
