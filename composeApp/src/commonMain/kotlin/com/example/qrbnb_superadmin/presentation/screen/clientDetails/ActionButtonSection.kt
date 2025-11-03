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
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.presentation.reusable_composables.PrimaryActionButton
import com.example.qrbnb_superadmin.ui.client_details_activate_delete_export_client_data_text_color
import com.example.qrbnb_superadmin.ui.client_details_btn_color

@Composable
fun ActionButtonsSection(
    actions: List<ClientAction>,
    onActivateClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onExportClick: () -> Unit,
) {
    Logger.d("ActionButtonsSection", "Actions count: ${actions.size}")

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        actions.forEachIndexed { index, clientAction ->

            Logger.d("ActionButtonsSection", "Action: ${clientAction.action}, Label: ${clientAction.label}")

            if (index > 0) {
                Spacer(Modifier.height(16.dp))
            }

            when (clientAction.action.uppercase()) {
                "ACTIVATE" -> {
                    Logger.d("ActionButtonsSection", "Rendering ACTIVATE button")
                    PrimaryActionButton(
                        text = clientAction.label,
                        onClick = {
                            Logger.d("ActionButtonsSection", "Activate button clicked")
                            println("DEBUG: Activate button clicked")
                            onActivateClick()
                        },
                        backgroundColor = Color.Red,
                        textColor = Color.White,
                    )
                }

                "DELETE" ->
                    PrimaryActionButton(
                        text = clientAction.label,
                        onClick = {
                            Logger.d("ActionButtonsSection", "Delete button clicked")
                            onDeleteClick()
                        },
                        backgroundColor = Color.Red,
                        textColor = Color.White,
                    )

                "EXPORT" ->
                    PrimaryActionButton(
                        text = clientAction.label,
                        onClick = {
                            Logger.d("ActionButtonsSection", "Export button clicked")
                            onExportClick()
                        },
                        backgroundColor = Color.Red,
                        textColor = Color.White,
                    )

                else ->
                    PrimaryActionButton(
                        text = clientAction.label,
                        onClick = {
                            Logger.d("ActionButtonsSection", "Generic button clicked: ${clientAction.action}")
                        },
                        backgroundColor = client_details_btn_color,
                        textColor = client_details_activate_delete_export_client_data_text_color,
                    )
            }
        }

        Spacer(Modifier.height(16.dp)) // Final spacer after all buttons
    }
}
