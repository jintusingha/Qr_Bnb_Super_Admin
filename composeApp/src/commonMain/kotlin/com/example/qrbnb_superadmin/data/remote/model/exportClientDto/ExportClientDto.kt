package com.example.qrbnb_superadmin.data.remote.model.exportClientDto

import org.koin.core.logger.MESSAGE

data class ExportClientDto(
    val success: Boolean,
    val message: String,
    val data:ExportClientDataDto
)

data class ExportClientDataDto(
    val exportUrl:String
)