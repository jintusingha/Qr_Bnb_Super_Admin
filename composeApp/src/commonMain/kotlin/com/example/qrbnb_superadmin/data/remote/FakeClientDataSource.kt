package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.ClientsDataDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.ClientsResponseDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.FiltersDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.PaginationDto
import com.example.qrbnb_superadmin.data.remote.clientsoverviewDto.SummaryDto
import kotlinx.coroutines.delay

class FakeClientDataSource : ClientDataSource {

    override suspend fun getClients(): ClientsResponseDto {
        delay(1000)

        return ClientsResponseDto(
            success = true,
            data = ClientsDataDto(
                summary = SummaryDto(
                    totalClients = 120,
                    totalMenusLive = 85,
                    activeSubscriptions = 102
                ),
                filters = FiltersDto(
                    status = listOf("All", "Active", "Inactive", "Pending")
                ),
                clients = listOf(
                    ClientDto(
                        clientId = 12345,
                        clientName = "Olivia Carter",
                        status = "Active",
                        subscription = "Premium",
                        menusLive = 5,
                        lastActive = "2025-10-11T14:30:00Z"
                    ),
                    ClientDto(
                        clientId = 67890,
                        clientName = "Ethan Bennett",
                        status = "Active",
                        subscription = "Standard",
                        menusLive = 3,
                        lastActive = "2025-10-12T09:15:00Z"
                    ),
                    ClientDto(
                        clientId = 24680,
                        clientName = "Sophia Hayes",
                        status = "Inactive",
                        subscription = "Free",
                        menusLive = 0,
                        lastActive = "2025-09-29T18:45:00Z"
                    ),
                    ClientDto(
                        clientId = 13579,
                        clientName = "Noah Parker",
                        status = "Active",
                        subscription = "Premium",
                        menusLive = 8,
                        lastActive = "2025-10-10T16:00:00Z"
                    ),
                    ClientDto(
                        clientId = 97531,
                        clientName = "Ava Thompson",
                        status = "Pending",
                        subscription = "Trial",
                        menusLive = 1,
                        lastActive = null
                    ),



                ),
                pagination = PaginationDto(
                    page = 1,
                    pageSize = 20,
                    totalPages = 6,
                    totalCount = 120
                )
            )
        )
    }
}