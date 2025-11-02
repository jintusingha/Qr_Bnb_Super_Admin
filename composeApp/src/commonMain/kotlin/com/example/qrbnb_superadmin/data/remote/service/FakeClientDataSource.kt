package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsDataDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsResponseDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.FiltersDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.PaginationDto
import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.SummaryDto
import kotlinx.coroutines.delay

class FakeClientDataSource : ClientOverviewDataSource {

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
                        clientId = "12345",
                        contactName = "Olivia Carter"
                    ),
                    ClientDto(
                        clientId = "67890",
                        contactName = "Ethan Bennett",


                        ),
                    ClientDto(
                        clientId = "24680",
                        contactName = "Sophia Hayes",

                        ),
                    ClientDto(
                        clientId = "13579",
                        contactName = "Noah Parker",

                        ),
                    ClientDto(
                        clientId = "97531",
                        contactName = "Ava Thompson",

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