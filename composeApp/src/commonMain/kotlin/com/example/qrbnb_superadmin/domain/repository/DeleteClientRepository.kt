package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.DeleteClient

interface DeleteClientRepository {
    suspend fun DeleteClient(clientId:String): DeleteClient

}