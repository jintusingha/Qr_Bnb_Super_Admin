package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetAddClientFormUseCase
import com.example.qrbnb_superadmin.domain.usecase.SubmitAddClientFormUseCase
import com.example.qrbnb_superadmin.presentation.state.ClientFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ClientFormViewModel(
    private val getAddClientFormUseCase: GetAddClientFormUseCase,
    private val submitAddClientFormUseCase: SubmitAddClientFormUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ClientFormState>(ClientFormState.Loading)
    val uiState: StateFlow<ClientFormState> = _uiState.asStateFlow()

    init {
        loadForm()
    }

    private fun loadForm() {
        viewModelScope.launch {
            try {
                _uiState.value = ClientFormState.Loading
                val schema = getAddClientFormUseCase()
                _uiState.value = ClientFormState.Success(schema)
            } catch (e: Exception) {
                _uiState.value = ClientFormState.Error("Failed to load form: ${e.message}")
            }
        }
    }

    fun submitForm(formValues: Map<String, Any>) {
        viewModelScope.launch {
            try {
                val response = submitAddClientFormUseCase(formValues)

                if (response.success) {
                    _uiState.value = ClientFormState.SubmissionSuccess(response.message)
                } else {
                    _uiState.value = ClientFormState.SubmissionError(response.errors ?: emptyList())
                }
            } catch (e: Exception) {
                _uiState.value = ClientFormState.Error("Failed to submit form: ${e.message}")
            }
        }
    }

    fun resetForm() {
        loadForm()
    }
}