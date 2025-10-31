package com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto

import kotlinx.serialization.Serializable

@Serializable
data class OrderResponseDto(
    val success: Boolean,
    val message: String,
    val data: OrderDetailsDto
)
@Serializable
data class OrderDetailsDto(
    val orderId: String,
    val createdAt: String,
    val client: ClientDto,
    val customer: CustomerDto,
    val items: List<ItemDto>,
    val summary: SummaryDto,
    val timeline: List<TimelineDto>,
    val metadata: MetadataDto
)
@Serializable
data class ClientDto(
    val name: String,
    val address: String
)
@Serializable
data class CustomerDto(
    val name: String,
    val phone: String,
    val table: String
)
@Serializable
data class ItemDto(
    val name: String,
    val quantity: Int,
    val priceEach: Double,
    val notes: String,
    val subtotal: Double
)
@Serializable
data class SummaryDto(
    val subtotal: Double,
    val taxes: Double,
    val total: Double
)
@Serializable
data class TimelineDto(
    val status: String,
    val time: String
)
@Serializable
data class MetadataDto(
    val creator: String,
    val paymentMethod: String,
    val platform: String
)
