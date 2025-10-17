package com.example.qrbnb_superadmin.domain.entity

data class FormSchema(
    val title: String,
    val description: String,
    val fields: List<FormField>,
    val actions: List<FormAction>,
)

data class FormField(
    val id: String,
    val label: String,
    val type: String,
    val placeholder: String?,
    val required: Boolean,
    val options: List<Option>? = null,
    val validation: ValidationRule? = null,
    val visibleIf: Map<String, Boolean>? = null,
    val defaultValue: Boolean? = null,
)

data class Option(
    val label: String,
    val value: String,
)

data class FormAction(
    val id: String,
    val label: String,
    val type: String,
    val style: String,
)

data class ValidationRule(
    val minLength: Int? = null,
    val maxLength: Int? = null,
    val regex: String? = null,
)
