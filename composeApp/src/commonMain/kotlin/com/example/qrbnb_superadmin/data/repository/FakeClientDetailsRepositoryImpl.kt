package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.domain.entity.ActivityOverview
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientAction
import com.example.qrbnb_superadmin.domain.entity.ClientDetails
import com.example.qrbnb_superadmin.domain.entity.ClientInfo
import com.example.qrbnb_superadmin.domain.entity.TimelineEvent
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository

class FakeClientDetailsRepositoryImpl : ClientDetailsRepository {
    override suspend fun getClientDetails(): ClientDetails =
        ClientDetails(
            client =
                ClientInfo(
                    clientId = 67890,
                    name = "Ethan Carter",
                    email = "ethan.carter@email.com",
                    phone = "+1 (555) 123-4567",
                    avatarUrl = "https://cdn.qrbnb.io/avatars/ethan-carter.png",
                    registrationDate = "2023-01-15",
                    subscriptionStatus = "Active",
                ),
            activityOverview =
                ActivityOverview(
                    ordersPlaced = 120,
                    itemsCreated = 350,
                    categoriesCount = 15,
                    lastLogin = "2024-03-20",
                ),
            timeline =
                listOf(
                    TimelineEvent(
                        title = "Client Created",
                        date = "2023-01-15",
                        description = "Account successfully registered",
                    ),
                    TimelineEvent(
                        title = "Last Menu Update",
                        date = "2024-03-10",
                        description = "Client’s menu was last modified",
                    ),
                ),
            actions =
                listOf(
                    ClientAction("Activate", "activate_client", true),
                    ClientAction("Delete", "delete_client", true),
                    ClientAction("Export Client Data", "export_client_data", true),
                ),
        )
}
