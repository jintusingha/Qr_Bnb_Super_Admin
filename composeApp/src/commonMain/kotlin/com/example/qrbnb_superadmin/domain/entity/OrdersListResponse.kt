package com.example.qrbnb_superadmin.domain.entity

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderStatus

data class OrdersResponse(
    val statusSummary: List<OrderStatusSummary>,
    val orders: List<Order>,
)

data class OrderStatusSummary(
    val status: OrderStatus,
    val count: Int,
    val isCurrentSelection: Boolean,
)

data class Order(
    val id: String,
    val timeElapsed: String,
    val placementLocation: String,
    val guestIdentifier: String,
    val itemsSummary: String,
    val currentStatus: OrderStatus,
    val visualContextUrl: String?,
)

enum class OrderStatus {
    NEW,
    PREPARING,
    READY,
    DELIVERED,
    CANCELLED,
}
