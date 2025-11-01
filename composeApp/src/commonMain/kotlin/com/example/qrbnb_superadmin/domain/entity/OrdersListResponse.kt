package com.example.qrbnb_superadmin.domain.entity





data class OrdersListResponse(
    val success:Boolean,
    val message:String,
    val data:OrderListData

)

data class OrderListData(
    val summary:OrderListSummary,
    val orders:List<OrderListItem>
)
data class OrderListSummary(
    val new:Int,
    val preparing:Int,
    val ready:Int,
    val delivered:Int

)
data class OrderListItem(
    val orderId: String,
    val orderNumber: String,
    val status: String,
    val timeAgo: String,
    val table: String,
    val guest: OrderGuest,
    val items: OrderItems,
    val thumbnail: String,
    val actions: List<String>,
    val clientId: String
)
data class OrderGuest(
    val name: String
)

data class OrderItems(
    val summary: String,
    val count: Int
)




//data class OrdersResponse(
//    val statusSummary: List<OrderStatusSummary>,
//    val orders: List<Order>,
//)
//
//data class OrderStatusSummary(
//    val status: OrderStatus,
//    val count: Int,
//    val isCurrentSelection: Boolean,
//)
//
//data class Order(
//    val id: String,
//    val timeElapsed: String,
//    val placementLocation: String,
//    val guestIdentifier: String,
//    val itemsSummary: String,
//    val currentStatus: OrderStatus,
//    val visualContextUrl: String?,
//)
//
//enum class OrderStatus {
//    NEW,
//    PREPARING,
//    READY,
//    DELIVERED,
//    CANCELLED,
//}
