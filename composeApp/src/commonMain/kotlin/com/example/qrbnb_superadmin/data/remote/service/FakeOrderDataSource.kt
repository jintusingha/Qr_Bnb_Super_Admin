//package com.example.qrbnb_superadmin.data.remote.service
//
//import com.example.qrbnb_superadmin.data.remote.service.OrderDataSource
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.CustomerDetails
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.MetadataItem
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderAction
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsData
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsResponse
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderItem
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderStatusEventDto
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderSummary
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderTotals
//import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.RestaurantDetails
//import kotlinx.coroutines.delay
//
//class FakeOrderDataSource : OrderDataSource {
//
//    override suspend fun fetchOrderDetails(orderId: String): OrderDetailsResponse {
//        delay(500)
//
//
//
//        return OrderDetailsResponse(
//            success = true,
//            data = OrderDetailsData(
//                order = OrderSummary(
//                    orderId = "123456789",
//                    createdAt = "2024-07-26T10:30:00Z",
//                    createdAtFormatted = "10:30 AM, July 26, 2024",
//                    status = "Completed"
//                ),
//                restaurant = RestaurantDetails(
//                    id = "r_001",
//                    name = "The Cozy Corner Cafe",
//                    logoUrl = "https://cdn.qrbnb.io/restaurants/cozycorner.png",
//                    address = "123 Main Street, Anytown, USA"
//                ),
//                customer = CustomerDetails(
//                    id = "c_101",
//                    name = "Liam Carter",
//                    avatarUrl = "https://cdn.qrbnb.io/avatars/liam.png",
//                    phone = "(555) 123–4567",
//                    tableInfo = "Table 5"
//                ),
//                items = listOf(
//                    OrderItem(
//                        name = "Latte",
//                        quantity = 1,
//                        priceEach = 3.0,
//                        total = 3.0,
//                        notes = "Extra shot, No foam"
//                    ),
//                    OrderItem(
//                        name = "Chocolate Cr",
//                        quantity = 1,
//                        priceEach = 3.0,
//                        total = 3.0,
//                        notes = "Extra shot, No foam"
//                    ),
//                    OrderItem(
//                        name = "Latte",
//                        quantity = 1,
//                        priceEach = 3.0,
//                        total = 3.0,
//                        notes = "Extra shot, No foam"
//                    )
//                ),
//                totals = OrderTotals(
//                    subtotal = 9.0,
//                    tax = 1.5,
//                    total = 10.5,
//                    currency = "USD"
//                ),
//                timeline = listOf(
//                    OrderStatusEventDto(
//                        status = "Order Placed",
//                        timestamp = "2024-07-26T10:30:00Z",
//                        timeFormatted = "10:30 AM"
//                    ),
//                    OrderStatusEventDto(
//                        status = "Preparing",
//                        timestamp = "2024-07-26T10:35:00Z",
//                        timeFormatted = "10:35 AM"
//                    ),
//                    OrderStatusEventDto(
//                        status = "Ready for Pickup",
//                        timestamp = "2024-07-26T10:45:00Z",
//                        timeFormatted = "10:45 AM"
//                    ),
//                    OrderStatusEventDto(
//                        status = "Completed",
//                        timestamp = "2024-07-26T10:50:00Z",
//                        timeFormatted = "10:50 AM"
//                    )
//                ),
//                metadata = listOf(
//                    MetadataItem(label = "Creator", value = "Admin User"),
//                    MetadataItem(label = "Payment Method", value = "Credit Card"),
//                    MetadataItem(label = "Device", value = "iOS")
//                ),
//                actions = listOf(
//                    OrderAction(
//                        id = "refund",
//                        label = "Initiate Refund",
//                        type = "button",
//                        enabled = true,
//                        endpoint = "/api/superadmin/orders/123456789/refund",
//                        method = "POST"
//                    ),
//                    OrderAction(
//                        id = "printReceipt",
//                        label = "Print Receipt",
//                        type = "button",
//                        enabled = true,
//                        endpoint = "/api/superadmin/orders/123456789/receipt",
//                        method = "GET"
//                    )
//                )
//            )
//        )
//    }
//}