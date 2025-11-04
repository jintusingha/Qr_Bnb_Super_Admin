package com.example.qrbnb_superadmin.data.remote.model.exportClientDto

import kotlinx.serialization.Serializable
import org.koin.core.logger.MESSAGE
@Serializable
data class ExportClientDto(
    val success: Boolean,
    val message: String,
    val data:ExportClientDataDto
)
@Serializable
data class ExportClientDataDto(
    val exportUrl:String
)