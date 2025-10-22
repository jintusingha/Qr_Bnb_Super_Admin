package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetOrderDetailsUseCase
import com.example.qrbnb_superadmin.presentation.state.OrderDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderDetailsViewModel(

    private val getOrderDetailsUseCase: GetOrderDetailsUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(OrderDetailsUiState())
    val uiState: StateFlow<OrderDetailsUiState> = _uiState.asStateFlow()


    private val TEST_ORDER_ID = "123456789"

    init {

        loadOrderDetails(TEST_ORDER_ID)
    }


    fun loadOrderDetails(orderId: String) {

        if (_uiState.value.isLoading) return


        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        viewModelScope.launch {

            getOrderDetailsUseCase(orderId)
                .onSuccess { orderDetails ->

                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        details = orderDetails
                    )
                }
                .onFailure { error ->

                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = error.message ?: "An unknown error occurred."
                    )
                }
        }
    }
}