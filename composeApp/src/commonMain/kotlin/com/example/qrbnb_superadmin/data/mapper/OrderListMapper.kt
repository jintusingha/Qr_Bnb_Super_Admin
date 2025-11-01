package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderListItemDto
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderScreenData
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderStatus
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderStatusDto
import com.example.qrbnb_superadmin.domain.entity.Order
import com.example.qrbnb_superadmin.domain.entity.OrderStatusSummary
import com.example.qrbnb_superadmin.domain.entity.OrdersResponse

fun OrderScreenData.toDomain(): OrdersResponse =
    OrdersResponse(
        statusSummary = this.orderStatuses.map { it.toDomain() },
        orders = this.currentOrders.map { it.toDomain() },
    )

fun OrderStatusDto.toDomain(): OrderStatusSummary {
    val domainStatus =
        try {
            OrderStatus.valueOf(this.status.uppercase())
        } catch (e: IllegalArgumentException) {
            OrderStatus.NEW
        }

    return OrderStatusSummary(
        status = domainStatus,
        count = this.count,
        isCurrentSelection = this.isSelected,
    )
}

fun OrderListItemDto.toDomain(): Order {
    val domainStatus =
        try {
            OrderStatus.valueOf(this.status.name)
        } catch (e: IllegalArgumentException) {
            OrderStatus.NEW
        }

    return Order(
        id = this.orderId,
        timeElapsed = this.timeAgo,
        placementLocation = this.location,
        guestIdentifier = this.guestName,
        itemsSummary = this.totalItemsDescription,
        currentStatus = domainStatus,
        visualContextUrl = this.imageUrl,
    )
}
