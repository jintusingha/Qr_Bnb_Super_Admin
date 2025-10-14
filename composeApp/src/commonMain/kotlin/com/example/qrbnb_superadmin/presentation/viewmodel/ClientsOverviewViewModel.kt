package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetClientsOverviewUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientsUseCase
import com.example.qrbnb_superadmin.presentation.state.ClientsOverviewState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class ClientsOverviewViewModel(
    private val getClientsOverviewUseCase: GetClientsOverviewUseCase,
    private val getClientsUseCase: GetClientsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(ClientsOverviewState())
    val state: StateFlow<ClientsOverviewState> = _state.asStateFlow()

    private val _searchTerm = MutableStateFlow("")

    private val debouncedSearchTerm =
        _searchTerm
            .debounce(300L)

    init {
        loadData()
        setupSearchFilter()
    }

    fun onSearchTermChange(newTerm: String) {
        _searchTerm.value = newTerm
        _state.update { it.copy(searchTerm = newTerm) }
    }

    private fun setupSearchFilter() {
        debouncedSearchTerm
            .combine(_state) { term, currentState ->

                if (currentState.clients.isEmpty()) return@combine emptyList()

                val lowerCaseTerm = term.trim().lowercase()

                currentState.clients.filter { client ->
                    client.name.lowercase().contains(lowerCaseTerm) ||
                        client.id.contains(lowerCaseTerm)
                }
            }.onEach { filteredList ->

                _state.update { it.copy(filteredClients = filteredList) }
            }.launchIn(viewModelScope)
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
                        filteredClients = clients,
                        isLoading = false,
                    )
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
