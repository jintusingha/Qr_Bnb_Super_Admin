package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.ClientDetails

data class ClientDetailsState(
    val clientDetails: ClientDetails? = null,
    val isLoading: Boolean = false,
    val loadError: String? = null,
    val isActionLoading: Boolean = false,
    val actionError: String? = null,
    val successMessage: String? = null,
)
