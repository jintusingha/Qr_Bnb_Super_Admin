package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.ui.style_16_24_w500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextAreaFieldComponent(
    field: FormField,
    value: String,
    onValueChange: (Any) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier =
            Modifier
                .fillMaxWidth()
                .heightIn(min = 144.dp),
        shape = RoundedCornerShape(12.dp),
        maxLines = 5,
        colors =
            OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFF6B6B),
                unfocusedBorderColor = Color(0xFFE0E0E0),
            ),
    )
}
