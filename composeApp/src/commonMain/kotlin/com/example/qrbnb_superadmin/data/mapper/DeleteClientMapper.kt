package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.DeleteClientResponseDto.DeleteClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.DeleteClient


fun DeleteClientResponseDto.toDomain(): DeleteClient{
    return DeleteClient(
        success=success,
        message=message
    )
}