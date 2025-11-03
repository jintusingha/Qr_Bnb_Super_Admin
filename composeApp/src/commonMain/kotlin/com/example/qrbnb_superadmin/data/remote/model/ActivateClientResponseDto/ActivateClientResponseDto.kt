package com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto


data class ActivateClientResponseDto(
    val success:String,
    val message:String,
    val data:ClientStatusDto
)

data class ClientStatusDto(
    val clientId:String,
    val isActive:Boolean
)