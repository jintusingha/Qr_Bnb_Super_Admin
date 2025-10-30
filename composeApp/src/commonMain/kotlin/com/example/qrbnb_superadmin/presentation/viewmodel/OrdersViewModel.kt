package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersUseCase
import com.example.qrbnb_superadmin.presentation.state.OrdersUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(
    private val getOrdersUseCase: GetOrdersUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<OrdersUiState>(OrdersUiState.Loading)
    val state: StateFlow<OrdersUiState> = _state

    init{
        loadOrders()
    }

    fun loadOrders() {
        viewModelScope.launch {
            _state.value = OrdersUiState.Loading
            try {
                val result = getOrdersUseCase()
                _state.value =
                    OrdersUiState.Success(
                        ordersRes = result,
                    )
            } catch (e: Exception) {
                val errorMessage = e.message ?: "An unknown error occurred while loading orders."

                _state.value =
                    OrdersUiState.Error(
                        message = errorMessage,
                    )
            }
        }
    }
}
