package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.Loginbtn_style
import com.example.qrbnb_superadmin.ui.loginButton
import com.example.qrbnb_superadmin.ui.login_btn_background


@Composable
fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor:Color,
    textColor: Color = loginButton

) {
    Button(
        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .widthIn(min = 84.dp, max = 480.dp)
            .height(40.dp),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),

    ) {
        Text(
            text = text,
            style = Loginbtn_style(),
            color = textColor
        )
    }
}