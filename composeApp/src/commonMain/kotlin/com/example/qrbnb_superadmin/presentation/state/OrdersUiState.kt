package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.OrdersResponse

sealed interface OrdersUiState {
    data object Loading : OrdersUiState

    data class Success(
        val ordersRes: OrdersResponse,
    ) : OrdersUiState

    data class Error(
        val message: String,
    ) : OrdersUiState
}
