package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormAction
import com.example.qrbnb_superadmin.ui.style_16_24_w700

@Composable
fun FormActionButton(
    action: FormAction,
    onClick: () -> Unit,
) {
    val buttonModifier =
        Modifier
            .fillMaxWidth()
            .widthIn(min = 84.dp, max = 480.dp)
            .height(48.dp)

    val buttonShape = RoundedCornerShape(24.dp)

    when (action.style) {
        "primary" -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6B6B),
                    ),
                shape = buttonShape,
            ) {
                Text(action.label, style = style_16_24_w700())
            }
        }

        "secondary" -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF5F5F5),
                    ),
                shape = buttonShape,
            ) {
                Text(
                    action.label,
                    style = style_16_24_w700(),
                    color = Color.Black,
                )
            }
        }
    }
}
