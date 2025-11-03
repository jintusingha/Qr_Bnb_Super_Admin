package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.DeleteClientResponse

interface DeleteClientRepository {
    suspend fun DeleteClient(clientId:String): DeleteClientResponse

}