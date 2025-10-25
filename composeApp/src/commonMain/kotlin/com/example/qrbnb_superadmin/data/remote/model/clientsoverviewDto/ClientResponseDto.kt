package com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientsResponseDto(
    val success: Boolean,
    val data: ClientsDataDto,
)

@Serializable
data class ClientsDataDto(
    val summary: SummaryDto,
    val filters: FiltersDto? = null,
    // FIX: Gave Clients a default value of an empty list.
    @SerialName("recentClients")
    val clients: List<ClientDto> = emptyList(),
    val pagination: PaginationDto? = null,
)

@Serializable
data class SummaryDto(
    val totalClients: Int,
    val totalMenusLive: Int,
    val activeSubscriptions: Int,
)

@Serializable
data class FiltersDto(
    // Added a default value to prevent errors if the 'status' list is missing/null in the JSON.
    val status: List<String> = emptyList(),
)

@Serializable
data class ClientDto(

    @SerialName("clientId")
    val clientId: String,


    val contactName: String,
)

@Serializable
data class PaginationDto(
    val page: Int,
    val pageSize: Int,
    val totalPages: Int,
    val totalCount: Int,
)
