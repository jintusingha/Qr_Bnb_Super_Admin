package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.OrderDetails

data class OrderDetailsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val details: OrderDetails? = null
)