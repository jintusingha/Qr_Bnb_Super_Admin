package com.example.qrbnb_superadmin.domain.entity



data class OrderDetails(
    val orderId: String,
    val createdAt: String,
    val customer: Customer,
    val items: List<Item>,
    val summary: SummaryDomain,
    val timeline: List<TimelineEventOrderDetails>,
)
data class Customer(
    val name: String,
    val phone: String,
    val seatingName: String
)

data class ClientOrderDetails(
    val name: String,
    val address: String
)



data class Item(
    val name: String,
    val quantity: Int,
    val priceEach: Double,
    val notes: String,
    val subtotal: Double
)

data class SummaryDomain(
    val subtotal: Double,
    val taxes: Double,
    val total: Double
)

data class TimelineEventOrderDetails(
    val status: String,
    val time: String
)

data class Metadata(
    val creator: String,
    val paymentMethod: String,
    val platform: String
)
