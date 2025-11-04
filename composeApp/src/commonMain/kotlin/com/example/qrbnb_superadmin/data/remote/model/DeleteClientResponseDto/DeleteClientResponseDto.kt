package com.example.qrbnb_superadmin.data.remote.model.DeleteClientResponseDto

import kotlinx.serialization.Serializable


@Serializable
data class DeleteClientResponseDto(
    val success:Boolean,
    val message:String
)

