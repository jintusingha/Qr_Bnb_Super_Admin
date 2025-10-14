package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview

data class ClientsOverviewState(
    val isLoading: Boolean = false,
    val overview: ClientOverview? = null,
    val clients: List<Client> = emptyList(),
    val filteredClients: List<Client> = emptyList(),
    val searchTerm: String = "",
    val error: String? = null,
)
