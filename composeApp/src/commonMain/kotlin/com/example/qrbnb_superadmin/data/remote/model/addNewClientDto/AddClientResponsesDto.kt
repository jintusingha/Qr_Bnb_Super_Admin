package com.example.qrbnb_superadmin.data.remote.model.addNewClientDto

data class AddClientResponseDto(
    val success: Boolean,
    val message: String,
    val data: ClientDataDto? = null,
    val meta: ResponseMetaDto? = null,
    val errors: List<FormErrorDto>? = null
)

data class ClientDataDto(
    val entityId: Int,
    val status: String,
    val createdAt: String
)

data class ResponseMetaDto(
    val formId: String,
    val entityType: String
)

data class FormErrorDto(
    val id: String,
    val message: String
)