package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.DeleteClientResponseDto.DeleteClientResponseDto

interface DeleteClientRemoteDataSource {
    suspend fun deleteClient(clientId:String): DeleteClientResponseDto
}