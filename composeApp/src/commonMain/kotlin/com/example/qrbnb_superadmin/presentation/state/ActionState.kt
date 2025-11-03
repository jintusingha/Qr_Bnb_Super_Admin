package com.example.qrbnb_superadmin.presentation.state

data class ActionState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null
)