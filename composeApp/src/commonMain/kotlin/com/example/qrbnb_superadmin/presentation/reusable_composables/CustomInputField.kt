package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.CustomLabelColor
import com.example.qrbnb_superadmin.ui.body16Regular

@Composable
fun CustomInputField(
    label:String,
    value:String,
    onValueChange:(String)->Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
){
    OutlinedTextField(
        value=value,
        onValueChange = onValueChange,
        label={
            Text(label, style = body16Regular(),
                color =CustomLabelColor
            )
        },
        modifier = Modifier.fillMaxWidth()
            .padding(vertical=8.dp),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF5F0F0),
            focusedContainerColor = Color(0xFFF5F0F0),
            disabledContainerColor = Color(0xFFF5F0F0),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(12.dp)
    )
}