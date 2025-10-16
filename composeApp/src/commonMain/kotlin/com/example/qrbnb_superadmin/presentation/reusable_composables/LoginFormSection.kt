package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.state.LoginState
import com.example.qrbnb_superadmin.ui.CustomLabelColor
import com.example.qrbnb_superadmin.ui.jakarta_regular_14px
import com.example.qrbnb_superadmin.ui.login_btn_background

@Composable
fun LoginFormSection(
    state: LoginState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
) {
    CustomInputField(
        label = "Email",
        value = state.emailInput,
        onValueChange = onEmailChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )

    CustomInputField(
        label = "Password",
        value = state.passwordInput,
        onValueChange = onPasswordChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
    Spacer(modifier = Modifier.height(10.dp))

    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Forgot password",
            style = jakarta_regular_14px(),
            color = CustomLabelColor,
            modifier = Modifier.align(Alignment.CenterStart)
                .offset(x = (5).dp)

        )
    }
    Spacer(modifier = Modifier.height(25.dp))

    PrimaryActionButton(
        "Login",
        onLoginClicked,
        backgroundColor = login_btn_background

    )
}
