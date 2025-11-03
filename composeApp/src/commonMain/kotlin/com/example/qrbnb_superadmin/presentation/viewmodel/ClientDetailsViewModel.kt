package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.ActivateClientUseCase
import com.example.qrbnb_superadmin.domain.usecase.DeleteClientUseCase
import com.example.qrbnb_superadmin.domain.usecase.ExportClientUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.presentation.state.ClientDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClientDetailsViewModel(
    private val clientId: String,
    private val getClientDetailsUseCase: GetClientDetailsUseCase,
    private val activateClientUseCase: ActivateClientUseCase,
    private val deleteClientUseCase: DeleteClientUseCase,
    private val exportClientUseCase: ExportClientUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ClientDetailsState())
    val state: StateFlow<ClientDetailsState> = _state

    fun fetchClientDetails() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, loadError = null)
            try {
                val details = getClientDetailsUseCase(clientId)
                _state.value = _state.value.copy(clientDetails = details)
            } catch (e: Exception) {
                _state.value = _state.value.copy(loadError = e.message ?: "Failed to load client details")
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }

    fun activateClient() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isActionLoading = true, actionError = null)
            try {
                val response = activateClientUseCase(clientId)
                _state.value = _state.value.copy(successMessage = "Client activated successfully!")
            } catch (e: Exception) {
                _state.value = _state.value.copy(actionError = e.message ?: "Activation failed")
            } finally {
                _state.value = _state.value.copy(isActionLoading = false)
            }
        }
    }

    fun deleteClient() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isActionLoading = true, actionError = null)
            try {
                val response = deleteClientUseCase(clientId)
                _state.value = _state.value.copy(successMessage = "client deleted successfully!")
            } catch (e: Exception) {
                _state.value = _state.value.copy(actionError = e.message ?: "Deletion Failed")
            } finally {
                _state.value = _state.value.copy(isActionLoading = false)
            }
        }
    }
    fun exportClient(){
        viewModelScope.launch {
            _state.value=_state.value.copy(isActionLoading = true, actionError = null)
            try{
                val reponse=exportClientUseCase(clientId)
                _state.value=_state.value.copy(successMessage = "client data exported successfully")

            }catch (e: Exception){
                _state.value=_state.value.copy(actionError = e.message?:"export failed")
            }finally {
                _state.value=_state.value.copy(isActionLoading = false)
            }
        }
    }
}
