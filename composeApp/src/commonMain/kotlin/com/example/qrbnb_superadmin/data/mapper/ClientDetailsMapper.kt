package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ActivityOverviewDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientActionDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientInfoDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.TimelineEventDto


import com.example.qrbnb_superadmin.domain.entity.*

fun ClientDetailsDto.toDomain(): ClientDetails {
    return ClientDetails(
        client = client.toDomain(),
        activityOverview = activityOverview.toDomain(),
        timeline = timeline.map { it.toDomain() },
        actions = actions.map { it.toDomain() }
    )
}

fun ClientInfoDto.toDomain() = ClientInfo(
    clientId = clientId,
    name = name,
    email = email,
    phone = phone,
    avatarUrl = avatarUrl,
    registrationDate = registrationDate,
    subscriptionStatus = subscriptionStatus
)

fun ActivityOverviewDto.toDomain() = ActivityOverview(
    ordersPlaced = ordersPlaced,
    itemsCreated = itemsCreated,
    categoriesCount = categoriesCount,
    lastLogin = lastLogin
)

fun TimelineEventDto.toDomain() = TimelineEvent(
    title = title,
    date = date,
    description = description
)

fun ClientActionDto.toDomain() = ClientAction(
    label = label,
    action = action,
    enabled = enabled
)
