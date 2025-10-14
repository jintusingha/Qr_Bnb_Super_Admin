package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview
import com.example.qrbnb_superadmin.domain.repository.ClientRepository
import kotlinx.coroutines.delay


class FakeClientRepositoryImpl : ClientRepository{
    override suspend fun getAllClients(): List<Client> {
        delay(1000)
        return listOf(
            Client(id = "12345","Olivia Carter"),
            Client(id="55555","Ethan Bennett"),
            Client(id="234444","Sophia Hayes"),
            Client("13455","Noah Parket"),
            Client("97363","Ava Thompson")

        )

    }

    override suspend fun getOverviewCounts(): ClientOverview {
        delay(500)
        return ClientOverview(
            totalClients = 120,
            totalMenusLive = 85,
            activeSubscriptions = 102
        )

    }

}