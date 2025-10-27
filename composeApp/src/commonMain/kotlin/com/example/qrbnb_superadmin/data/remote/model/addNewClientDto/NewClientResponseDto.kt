package com.example.qrbnb_superadmin.data.remote.model.addNewClientDto

import kotlinx.serialization.Serializable

@Serializable
data class FormSchemaResponse(
    val success: Boolean,
    val data: FormData
)
@Serializable
data class FormData(
    val formId: String,
    val title: String,
    val description: String,
    val fields: List<FormField>,
    val actions: List<FormAction>
)
@Serializable
data class FormField(
    val id: String,
    val label: String,
    val type: String,
    val placeholder: String? = null,      // optional
    val required: Boolean = false,         // default false
    val validation: ValidationRule? = null,
    val options: List<Option>? = null,
    val defaultValue: Boolean? = null,
    val description: String? = null,
    val visibleIf: Map<String, Boolean>? = null
)
@Serializable
data class ValidationRule(
    val minLength: Int? = null,
    val maxLength: Int? = null,
    val regex: String? = null
)
@Serializable
data class Option(
    val label: String,
    val value: String
)
@Serializable
data class FormAction(
    val id: String,
    val label: String,
    val type: String,
    val style: String,
    val endpoint: String? = null,
    val method: String? = null
)
