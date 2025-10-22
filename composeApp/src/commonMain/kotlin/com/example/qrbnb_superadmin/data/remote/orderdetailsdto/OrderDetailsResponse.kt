package com.example.qrbnb_superadmin.data.remote.orderdetailsdto


data class OrderDetailsResponse(
    val success: Boolean,
    val data: OrderDetailsData
)


data class OrderDetailsData(
    val order: OrderSummary,
    val restaurant: RestaurantDetails,
    val customer: CustomerDetails,
    val items: List<OrderItem>,
    val totals: OrderTotals,
    val timeline: List<OrderStatusEventDto>,
    val metadata: List<MetadataItem>,
    val actions: List<OrderAction>
)

data class OrderSummary(
    val orderId: String,
    val createdAt: String,
    val createdAtFormatted: String,
    val status: String
)

data class RestaurantDetails(
    val id: String,
    val name: String,
    val logoUrl: String,
    val address: String
)

data class CustomerDetails(
    val id: String,
    val name: String,
    val avatarUrl: String,
    val phone: String,
    val tableInfo: String
)

data class OrderItem(
    val name: String,
    val quantity: Int,
    val priceEach: Double,
    val total: Double,
    val notes: String
)

data class OrderTotals(
    val subtotal: Double,
    val tax: Double,
    val total: Double,
    val currency: String
)

data class OrderStatusEventDto(
    val status: String,
    val timestamp: String,
    val timeFormatted: String
)

data class MetadataItem(
    val label: String,
    val value: String
)

data class OrderAction(
    val id: String,
    val label: String,
    val type: String,
    val enabled: Boolean,
    val endpoint: String,
    val method: String
)
