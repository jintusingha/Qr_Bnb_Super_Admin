package com.example.qrbnb_superadmin.data.remote.clientsoverviewDto

data class ClientsResponseDto(
    val success: Boolean,
    val data: ClientsDataDto
)

data class ClientsDataDto(
    val summary: SummaryDto,
    val filters: FiltersDto,
    val clients: List<ClientDto>,
    val pagination: PaginationDto
)

data class SummaryDto(
    val totalClients: Int,
    val totalMenusLive: Int,
    val activeSubscriptions: Int
)

data class FiltersDto(
    val status: List<String>
)

data class ClientDto(
    val clientId: Int,
    val clientName: String,
    val status: String,
    val subscription: String,
    val menusLive: Int,
    val lastActive: String?
)

data class PaginationDto(
    val page: Int,
    val pageSize: Int,
    val totalPages: Int,
    val totalCount: Int
)