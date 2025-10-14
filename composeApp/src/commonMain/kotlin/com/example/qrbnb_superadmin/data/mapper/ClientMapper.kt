package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.SummaryDto
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview

fun ClientDto.toClient(): Client {
    return Client(
        id = clientId.toString(),
        name = clientName,
        status = status
    )
}

fun SummaryDto.toClientOverview(): ClientOverview {
    return ClientOverview(
        totalClients = totalClients,
        totalMenusLive = totalMenusLive,
        activeSubscriptions = activeSubscriptions
    )
}