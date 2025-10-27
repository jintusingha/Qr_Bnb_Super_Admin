package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ActivityOverviewDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientInfoDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.TimelineEventDto
import com.example.qrbnb_superadmin.domain.entity.*

fun ClientDetailsDto.toDomain(): ClientDetails =
    ClientDetails(
        client = profile.toDomain(clientId),
        activityOverview = activity.toDomain(),
        timeline = timeline.map { it.toDomain() },
        actions =
            listOf(
                ClientAction("Activate", "activate", actions.canActivate),
                ClientAction("Delete", "delete", actions.canDelete),
                ClientAction("Export", "export", actions.canExport),
            ),
    )

fun ClientInfoDto.toDomain(clientId: String) =
    ClientInfo(
        clientId = clientId.toIntOrNull() ?: -1,
        name = name,
        email = email,
        phone = phone,
        avatarUrl = avatarUrl,
        registrationDate = registrationDate,
        subscriptionStatus = subscriptionStatus,
    )

fun ActivityOverviewDto.toDomain() =
    ActivityOverview(
        ordersPlaced = ordersPlaced,
        itemsCreated = itemsCreated,
        categoriesCount = categoriesCount,
        lastLogin = lastLogin,
    )

fun TimelineEventDto.toDomain() =
    TimelineEvent(
        title = label,
        date = date,
        description = "",
    )
