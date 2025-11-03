package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDataDto
import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDto
import com.example.qrbnb_superadmin.domain.entity.ExportClientData
import com.example.qrbnb_superadmin.domain.entity.ExportClientResponse


fun ExportClientDto.toDomain(): ExportClientResponse{
    return ExportClientResponse(
        success=success,
        message=message,
        data= ExportClientData(
            exportUrl = data.exportUrl
        )
    )
}