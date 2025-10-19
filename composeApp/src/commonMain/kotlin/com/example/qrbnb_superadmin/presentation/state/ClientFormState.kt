package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.data.remote.addNewClientDto.FormErrorDto
import com.example.qrbnb_superadmin.domain.entity.FormSchema

sealed interface ClientFormState {
    data object Loading : ClientFormState
    data class Success(val formSchema: FormSchema) : ClientFormState
    data class SubmissionSuccess(val message: String) : ClientFormState
    data class SubmissionError(val errors: List<FormErrorDto>) : ClientFormState
    data class Error(val message: String) : ClientFormState
}
