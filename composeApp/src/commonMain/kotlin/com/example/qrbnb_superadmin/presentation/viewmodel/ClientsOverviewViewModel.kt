package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetClientsOverviewUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientsUseCase
import com.example.qrbnb_superadmin.presentation.state.ClientsOverviewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ClientsOverviewViewModel(
    private val getClientsOverviewUseCase: GetClientsOverviewUseCase,
    private val getClientsUseCase: GetClientsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ClientsOverviewState())
    val state: StateFlow<ClientsOverviewState> = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val overview = getClientsOverviewUseCase()
                val clients = getClientsUseCase()

                _state.update {
                    it.copy(
                        overview = overview,
                        clients = clients,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}