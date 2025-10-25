package com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto

data class ClientDetailsDto(
    val client: ClientInfoDto,
    val activityOverview: ActivityOverviewDto,
    val timeline: List<TimelineEventDto>,
    val actions: List<ClientActionDto>,
)

data class ClientInfoDto(
    val clientId: Int,
    val name: String,
    val email: String,
    val phone: String,
    val avatarUrl: String,
    val registrationDate: String,
    val subscriptionStatus: String,
)

data class ActivityOverviewDto(
    val ordersPlaced: Int,
    val itemsCreated: Int,
    val categoriesCount: Int,
    val lastLogin: String,
)

data class TimelineEventDto(
    val title: String,
    val date: String,
    val description: String,
)

data class ClientActionDto(
    val label: String,
    val action: String,
    val enabled: Boolean,
)
