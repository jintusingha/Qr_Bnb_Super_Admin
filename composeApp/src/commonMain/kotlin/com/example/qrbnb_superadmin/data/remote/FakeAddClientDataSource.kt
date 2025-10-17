package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormAction
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormData
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormField
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormSchemaResponse
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.Option
import com.example.qrbnb_superadmin.data.remote.addNewClientDto.ValidationRule
import kotlinx.coroutines.delay

class FakeAddClientDataSource : AddNewClientDataSource {
    override suspend fun getAddClientFormSchema(): FormSchemaResponse {
        // Simulate network delay
        delay(500)

        // Return the hardcoded JSON response structure (DTOs)
        return FormSchemaResponse(
            success = true,
            data = FormData(
                formId = "add_client",
                title = "Add New Client",
                description = "Create a new client account and optionally send them an invite email.",
                fields = listOf(
                    FormField(
                        id = "businessName",
                        label = "Business Name",
                        type = "text",
                        placeholder = "Enter business name",
                        required = true,
                        validation = ValidationRule(minLength = 2, maxLength = 100)
                    ),
                    FormField(
                        id = "contactName",
                        label = "Contact Name",
                        type = "text",
                        placeholder = "Enter contact name",
                        required = true
                    ),
                    FormField(
                        id = "email",
                        label = "Email",
                        type = "email",
                        placeholder = "Enter email",
                        required = true,
                        validation = ValidationRule(regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
                    ),
                    FormField(
                        id = "phoneNumber",
                        label = "Phone Number",
                        type = "tel",
                        placeholder = "Enter phone number",
                        required = false
                    ),
                    FormField(
                        id = "planType",
                        label = "Plan Type",
                        type = "select",
                        placeholder = "Select plan type",
                        required = true,
                        options = listOf(
                            Option("Basic", "basic"),
                            Option("Standard", "standard"),
                            Option("Premium", "premium")
                        )
                    ),
                    FormField(
                        id = "sendInviteEmail",
                        label = "Send Invite Email",
                        type = "switch",
                        defaultValue = false,
                        description = "Client will receive an email with their login details."
                    ),
                    FormField(
                        id = "emailPreview",
                        label = "Email Preview",
                        type = "textarea",
                        placeholder = "Email content preview...",
                        required = false,
                        visibleIf = mapOf("sendInviteEmail" to true) // Dynamic visibility rule
                    )
                ),
                actions = listOf(
                    FormAction(
                        id = "save",
                        label = "Save Client",
                        type = "submit",
                        style = "primary",
                        endpoint = "/api/superadmin/clients",
                        method = "POST"
                    ),
                    FormAction(
                        id = "cancel",
                        label = "Cancel",
                        type = "button",
                        style = "secondary"
                    )
                )
            )
        )
    }
}
