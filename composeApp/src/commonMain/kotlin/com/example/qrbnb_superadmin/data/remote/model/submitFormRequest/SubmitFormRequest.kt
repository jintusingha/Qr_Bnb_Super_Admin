package com.example.qrbnb_superadmin.data.remote.model.submitFormRequest

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@kotlinx.serialization.Serializable
data class SubmitFormRequest(
    val formId: String,
    val values: List<FormValue>
)

@Serializable
data class FormValue(
    val id: String,
    val value: JsonElement
)