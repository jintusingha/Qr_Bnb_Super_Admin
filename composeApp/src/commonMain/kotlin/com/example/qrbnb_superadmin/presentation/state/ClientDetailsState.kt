package com.example.qrbnb_superadmin.presentation.state

import com.example.qrbnb_superadmin.domain.entity.ClientDetails


data class ClientDetailsState(
    val clientDetails: ClientDetails?=null,
    val isLoading:Boolean=false,
    val error:String?=null
)