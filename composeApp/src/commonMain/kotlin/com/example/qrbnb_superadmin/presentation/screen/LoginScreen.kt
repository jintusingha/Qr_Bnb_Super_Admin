package com.example.qrbnb_superadmin.presentation.screen

import org.koin.compose.koinInject
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrbnb_superadmin.presentation.state.LoginState
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel



@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinInject(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    LoginContent(
        state = state,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onLoginClicked = viewModel::login,
        modifier = modifier,
    )
}

@Composable
private fun LoginContent(
    state: LoginState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "QRBnB Superadmin",
                fontSize = 24.sp,
                color = Color(0xFF333333),
                modifier = Modifier.padding(bottom = 24.dp),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF2D4A2B), Color(0xFF8B7355))
                        ),
                        shape = RoundedCornerShape(12.dp),
                    ),
            )


            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = state.emailInput,
                onValueChange = onEmailChanged,
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                enabled = !state.isLoading,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF0F0F0),
                    focusedContainerColor = Color(0xFFF0F0F0),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFFFF6B6B),
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.passwordInput,
                onValueChange = onPasswordChanged,
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                enabled = !state.isLoading,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF0F0F0),
                    focusedContainerColor = Color(0xFFF0F0F0),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFFFF6B6B),
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = { /* Handle forgot password */ },
                modifier = Modifier.align(Alignment.Start),
            ) {
                Text(
                    text = "Forgot Password",
                    color = Color(0xFF666666),
                    fontSize = 14.sp,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onLoginClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !state.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B6B)),
                shape = RoundedCornerShape(28.dp),
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White,
                        strokeWidth = 2.dp,
                    )
                } else {
                    Text(
                        text = "Login",
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "QRBnB Superadmin Panel",
                fontSize = 12.sp,
                color = Color(0xFF999999),
            )
        }
    }
}
