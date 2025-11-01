package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderListItemDto
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderScreenData
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderStatus
import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderStatusDto
import kotlinx.coroutines.delay

class FakeOrderListDataSource (): OrderListDataSource {
    override suspend fun getOrdersData(): OrderScreenData {
        delay(500)

        return OrderScreenData(
            orderStatuses = listOf(
                OrderStatusDto("New",3,true),
                OrderStatusDto("PREPARING",2,false),
                OrderStatusDto("READY",2,false),
                OrderStatusDto("DELIVERED",8,false)

            ), currentOrders =listOf(
                OrderListItemDto(
                    orderId = "123",
                    timeAgo = "10 min ago",
                    location = "Table 7",
                    guestName = "Ethan Carter",
                    totalItemsDescription = "2 items + 1 more",
                    status = OrderStatus.NEW,
                    imageUrl = "https://image.com/dishses.jpg"
                ),OrderListItemDto(
                    orderId = "1235",
                    timeAgo = "15 min ago",
                    location = "Room 201",
                    guestName = "Olivia Bennett",
                    totalItemsDescription = "3 items",
                    status = OrderStatus.PREPARING,
                    imageUrl = "https://yourimageurl.com/room.jpg"
                ),
                OrderListItemDto(
                    orderId = "1236",
                    timeAgo = "20 min ago",
                    location = "Table 12",
                    guestName = "Noah Thompson",
                    totalItemsDescription = "1 item + 2 more",
                    status = OrderStatus.NEW,
                    imageUrl = "https://yourimageurl.com/table.jpg"
                )

            )
        )

    }
}