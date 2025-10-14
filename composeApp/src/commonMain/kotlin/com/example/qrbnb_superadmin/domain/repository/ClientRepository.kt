package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview


interface ClientRepository{
    suspend fun getAllClients():List<Client>
    suspend fun getOverviewCounts(): ClientOverview
}