package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.OrdersOverview



sealed interface OrdersOverviewState{

    data object Loading: OrdersOverviewState
    data class Success(val data: OrdersOverview): OrdersOverviewState
    data class Error(val message:String): OrdersOverviewState
}