package com.example.qrbnb_superadmin.domain.entity



data class ClientOverview(
    val totalClients:Int,
    val totalMenusLive:Int,
    val activeSubscriptions:Int
)