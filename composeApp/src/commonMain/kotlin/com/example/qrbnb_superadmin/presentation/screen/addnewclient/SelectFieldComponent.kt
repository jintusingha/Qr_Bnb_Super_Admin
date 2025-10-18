package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.ui.add_new_client_placeholder_text_color
import com.example.qrbnb_superadmin.ui.body16Regular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectFieldComponent(
    field: FormField,
    value: String,
    onValueChange: (Any) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(field.placeholder ?: "",style = body16Regular(), color = add_new_client_placeholder_text_color) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(12.dp),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },

            colors = OutlinedTextFieldDefaults.colors(

                unfocusedBorderColor = Color(0xFFE0E0E0),
                focusedBorderColor = Color(0xFFFF6B6B),

            )
        )


        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            field.options?.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.label) },
                    onClick = {
                        onValueChange(option.value)
                        expanded = false
                    }
                )
            }
        }
    }
}
