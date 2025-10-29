package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersOverviewUseCase
import com.example.qrbnb_superadmin.presentation.state.OrdersOverviewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrdersOverviewViewModel(
    private val getOrdersOverviewUseCase: GetOrdersOverviewUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<OrdersOverviewState>(OrdersOverviewState.Loading)
    val state: StateFlow<OrdersOverviewState> = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        _state.value = OrdersOverviewState.Loading
        viewModelScope.launch {
            try {
                val domainData = getOrdersOverviewUseCase()
                _state.value = OrdersOverviewState.Success(domainData)
            } catch (e: Exception) {
                _state.value =
                    OrdersOverviewState.Error(
                        message = "An unknown error occurred while loading data",
                    )
            }
        }
    }
}
