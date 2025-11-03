package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto.ActivateClientResponseDto
import com.example.qrbnb_superadmin.domain.entity.Client


interface ActivateClientRemoteDataSource{
    suspend fun activateClient(clientId:String): ActivateClientResponseDto
}