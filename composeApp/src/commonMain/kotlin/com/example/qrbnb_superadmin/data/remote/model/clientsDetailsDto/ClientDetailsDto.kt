package com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto

import kotlinx.serialization.Serializable

@Serializable
data class ClientDetailsResponseDto(
    val success: Boolean,
    val message: String,
    val data: ClientDetailsDto
)


@Serializable
data class ClientDetailsDto(
    val clientId: String,
    val profile: ClientInfoDto,
    val activity: ActivityOverviewDto,
    val timeline: List<TimelineEventDto>,
    val actions: ClientActionsDto
)


@Serializable
data class ClientInfoDto(
    val avatarUrl: String,
    val name: String,
    val email: String,
    val phone: String,
    val registrationDate: String,
    val subscriptionStatus: String
)


@Serializable
data class ActivityOverviewDto(
    val ordersPlaced: Int,
    val itemsCreated: Int,
    val categoriesCount: Int,
    val lastLogin: String
)


@Serializable
data class TimelineEventDto(
    val label: String,
    val date: String
)


@Serializable
data class ClientActionsDto(
    val canActivate: Boolean,
    val canDelete: Boolean,
    val canExport: Boolean
)