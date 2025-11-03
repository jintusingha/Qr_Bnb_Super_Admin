package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto.ActivateClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.ActivateClient

fun ActivateClientResponseDto.toDomain(): ActivateClient {
    return ActivateClient(
        clientId = this.data.clientId,
        isActive = this.data.isActive
    )
}