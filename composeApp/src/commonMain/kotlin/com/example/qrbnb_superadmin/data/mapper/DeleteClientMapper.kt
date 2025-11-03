package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.DeleteClientResponseDto.DeleteClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.DeleteClientResponse


fun DeleteClientResponseDto.toDomain(): DeleteClientResponse{
    return DeleteClientResponse(
        success=success,
        message=message
    )
}