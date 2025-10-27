package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.presentation.state.ClientDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClientDetailsViewModel(
    private val clientId:String,
    private val getClientDetailsUseCase: GetClientDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ClientDetailsState())
    val state: StateFlow<ClientDetailsState> = _state

    fun fetchClientDetails() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                val details = getClientDetailsUseCase(clientId)
                _state.value = _state.value.copy(clientDetails = details)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message ?: "Unknown Error")
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }
}