package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto.ActivateClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.ActivateClientResponse

fun ActivateClientResponseDto.toDomain(): ActivateClientResponse {
    return ActivateClientResponse(
        clientId = this.data.clientId,
        isActive = this.data.isActive
    )
}