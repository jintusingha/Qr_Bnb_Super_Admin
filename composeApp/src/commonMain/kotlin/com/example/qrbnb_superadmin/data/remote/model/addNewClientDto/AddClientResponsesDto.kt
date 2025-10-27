package com.example.qrbnb_superadmin.data.remote.model.addNewClientDto

import kotlinx.serialization.Serializable

@Serializable
data class AddClientResponseDto(
    val success: Boolean,
    val message: String,
    val data: ClientDataDto? = null,
    val meta: ResponseMetaDto? = null,
    val errors: List<FormErrorDto>? = null
)
@Serializable
data class ClientDataDto(
    val entityId: Int,
    val status: String,
    val createdAt: String
)
@Serializable
data class ResponseMetaDto(
    val formId: String,
    val entityType: String
)
@Serializable
data class FormErrorDto(
    val id: String,
    val message: String
)