package com.example.qrbnb_superadmin.presentation.screen.addnewclientformsubmission

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.FormErrorDto

@Composable
fun SubmissionErrorDialog(
    errors: List<FormErrorDto>,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Validation Failed",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Please fix the following errors:",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                errors.forEachIndexed { index, error ->
                    // Format the field name nicely
                    val fieldName = formatFieldName(error.id)

                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "❌ $fieldName",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFFD32F2F) // Red
                        )
                        Text(
                            text = error.message,
                            fontSize = 13.sp,
                            modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                            color = Color(0xFF424242) // Dark gray
                        )
                    }

                    // Add separator between errors except after last one
                    if (index < errors.size - 1) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Try Again")
            }
        }
    )
}

// Helper function to convert field ID to readable name
private fun formatFieldName(fieldId: String): String {
    return when (fieldId) {
        "businessName" -> "Business Name"
        "contactName" -> "Contact Name"
        "email" -> "Email Address"
        "phoneNumber" -> "Phone Number"
        "planType" -> "Plan Type"
        "sendInviteEmail" -> "Send Invite Email"
        "emailPreview" -> "Email Preview"
        else -> fieldId
    }
}