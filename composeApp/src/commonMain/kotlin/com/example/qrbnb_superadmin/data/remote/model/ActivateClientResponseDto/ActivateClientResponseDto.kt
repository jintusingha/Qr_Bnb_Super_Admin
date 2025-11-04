package com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto

import kotlinx.serialization.Serializable

@Serializable
data class ActivateClientResponseDto(
    val success:String,
    val message:String,
    val data:ClientStatusDto
)
@Serializable
data class ClientStatusDto(
    val clientId:String,
    val isActive:Boolean
)