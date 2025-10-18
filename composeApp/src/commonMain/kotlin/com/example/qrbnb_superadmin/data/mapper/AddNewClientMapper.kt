package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormSchemaResponse
import com.example.qrbnb_superadmin.domain.entity.FormAction
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.domain.entity.FormSchema
import com.example.qrbnb_superadmin.domain.entity.Option
import com.example.qrbnb_superadmin.domain.entity.ValidationRule



fun FormSchemaResponse.toDomain(): FormSchema {
    val d = this.data
    return FormSchema(
        title = d.title,
        description = d.description,
        fields = d.fields.map { formFieldDto ->
            FormField(
                id = formFieldDto.id,
                label = formFieldDto.label,
                type = formFieldDto.type,
                placeholder = formFieldDto.placeholder,
                required = formFieldDto.required,
                defaultValue = formFieldDto.defaultValue,
                validation = formFieldDto.validation?.let {
                    ValidationRule(it.minLength, it.maxLength, it.regex)
                },
                visibleIf = formFieldDto.visibleIf,
                options = formFieldDto.options?.map { opt ->
                    Option(opt.label, opt.value)
                },
                description = formFieldDto.description
            )
        },
        actions = d.actions.map { formActionDto ->
            FormAction(
                id = formActionDto.id,
                label = formActionDto.label,
                type = formActionDto.type,
                style = formActionDto.style
            )
        }
    )
}
