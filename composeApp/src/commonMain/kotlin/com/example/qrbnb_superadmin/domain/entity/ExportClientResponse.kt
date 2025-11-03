package com.example.qrbnb_superadmin.domain.entity

import com.example.qrbnb_superadmin.presentation.state.ClientFormState

data class ExportClientResponse(
    val success:Boolean,
    val message:String,
    val data:ExportClientData
)

data class ExportClientData(
    val exportUrl:String
)