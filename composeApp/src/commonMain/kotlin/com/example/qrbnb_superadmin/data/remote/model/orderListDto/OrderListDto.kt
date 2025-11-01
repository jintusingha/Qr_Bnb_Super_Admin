package com.example.qrbnb_superadmin.data.remote.model.orderListDto

data class OrderScreenData(
    val orderStatuses: List<OrderStatusDto>,
    val currentOrders: List<OrderListItemDto>,
)

data class OrderStatusDto(
    val status: String,
    val count: Int,
    val isSelected: Boolean,
)

data class OrderListItemDto(
    val orderId: String,
    val timeAgo: String,
    val location: String,
    val guestName: String,
    val totalItemsDescription: String,
    val status: OrderStatus,
    val imageUrl: String?,
)

enum class OrderStatus {
    NEW,
    PREPARING,
    READY,
    DELIVERED,
    CANCELLED,
}
