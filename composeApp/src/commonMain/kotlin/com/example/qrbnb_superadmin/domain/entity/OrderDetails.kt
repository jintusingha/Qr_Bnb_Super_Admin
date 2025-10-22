package com.example.qrbnb_superadmin.domain.entity



// Core Entity
// Core domain entity
data class OrderDetails(
    val id: String,
    val date: String,
    val status: String,
    val restaurant: Restaurant,
    val customer: Customer,
    val items: List<Item>,
    val subtotal: Double,
    val total: Double,
    val tax: Double,
    val currency: String,
    val timeline: List<OrderTimelineEvent>,
    val metadata: List<MetadataPair>,
    val actions: List<OrderActionDetails>
)

data class Restaurant(
    val name: String,
    val address: String,
    val logoUrl: String
)

data class Customer(
    val name: String,
    val phone: String,
    val tableInfo: String
)

data class Item(
    val name: String,
    val quantity: Int,
    val unitPrice: Double,
    val itemTotal: Double,
    val notes: String
)

data class OrderTimelineEvent(
    val status: String,
    val time: String,
    val timestamp: String
)

data class MetadataPair(
    val label: String,
    val value: String
)

data class OrderActionDetails(
    val id: String,
    val label: String,
    val endpoint: String
)