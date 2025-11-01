package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.OrderListData


sealed interface OrdersUiState {
    data object Loading : OrdersUiState

    data class Success(
        val ordersRes: OrderListData,
    ) : OrdersUiState

    data class Error(
        val message: String,
    ) : OrdersUiState
}
