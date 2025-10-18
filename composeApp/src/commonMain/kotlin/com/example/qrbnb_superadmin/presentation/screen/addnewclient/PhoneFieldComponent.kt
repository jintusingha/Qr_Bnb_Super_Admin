package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.ui.add_new_client_placeholder_text_color
import com.example.qrbnb_superadmin.ui.body16Regular

@Composable
fun PhoneFieldComponent(
    field: FormField,
    value: String,
    onValueChange: (Any) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(field.placeholder ?: "", style = body16Regular(), color = add_new_client_placeholder_text_color) },
        modifier = Modifier.fillMaxWidth().height(56.dp),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors =
            OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE0E0E0),
                focusedBorderColor = Color(0xFFFF6B6B),
            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
    )
}
