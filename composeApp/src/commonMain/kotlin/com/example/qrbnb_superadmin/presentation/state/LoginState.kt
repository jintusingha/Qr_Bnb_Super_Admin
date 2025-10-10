package com.example.qrbnb_superadmin.presentation.state

data class LoginState(
    val emailInput: String = "",
    val passwordInput: String = "",
    val isLoading: Boolean = false
)
