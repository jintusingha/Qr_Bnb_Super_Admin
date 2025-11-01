package com.example.qrbnb_superadmin.data.remote.model.orderListDto

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewDataDto
import kotlinx.serialization.Serializable
import org.koin.core.logger.MESSAGE

@Serializable
data class OrderListResponseDto(
    val success: Boolean,
    val message: String,
    val data:OrderListDataDto
)
@Serializable
data class OrderListDataDto(
    val summary:OrderListSummaryDto,
    val orders:List<OrderListItemDto>
)
@Serializable
data class OrderListSummaryDto(
    val new: Int,
    val preparing: Int,
    val ready: Int,
    val delivered: Int
)
@Serializable
data class OrderListItemDto(
    val orderId: String,
    val orderNumber: String,
    val status: String,
    val timeAgo: String,
    val table: String,
    val guest: OrderGuestDto,
    val items: OrderItemsDto,
    val thumbnail: String,
    val actions: List<String>,
    val clientId: String
)
@Serializable
data class OrderGuestDto(
    val name: String
)

@Serializable
data class OrderItemsDto(
    val summary: String,
    val count: Int
)