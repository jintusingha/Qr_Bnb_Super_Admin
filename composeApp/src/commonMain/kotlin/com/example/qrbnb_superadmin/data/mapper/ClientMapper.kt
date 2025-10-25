package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.SummaryDto
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview

fun ClientDto.toClient(): Client {
    return Client(
        id = clientId.toString(),
        name = contactName,

    )
}

fun SummaryDto.toClientOverview(): ClientOverview {
    return ClientOverview(
        totalClients = totalClients,
        totalMenusLive = totalMenusLive,
        activeSubscriptions = activeSubscriptions
    )
}