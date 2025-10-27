//package com.example.qrbnb_superadmin.data.remote
//
//import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ActivityOverviewDto
//import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientActionDto
//import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto
//import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientInfoDto
//import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.TimelineEventDto
//import kotlinx.coroutines.delay
//
//class FakeClientDetailsDataSource : ClientDetailsDataSource {
//    override suspend fun getClientDetails(clientId:String): ClientDetailsDto {
//        delay(1000)
//
//        return ClientDetailsDto(
//            client =
//                ClientInfoDto(
//                    clientId = 67890,
//                    name = "Ethan Carter",
//                    email = "ethan.carter@email.com",
//                    phone = "+1 (555) 123-4567",
//                    avatarUrl = "https://cdn.qrbnb.io/avatars/ethan-carter.png",
//                    registrationDate = "2023-01-15",
//                    subscriptionStatus = "Active",
//                ),
//            activityOverview =
//                ActivityOverviewDto(
//                    ordersPlaced = 120,
//                    itemsCreated = 350,
//                    categoriesCount = 15,
//                    lastLogin = "2024-03-20",
//                ),
//            timeline =
//                listOf(
//                    TimelineEventDto(
//                        title = "Client Created",
//                        date = "2023-01-1",
//                        description = "Account successfully registered",
//                    ),
//                    TimelineEventDto(
//                        title = "Last Menu Update",
//                        date = "2024-03-10",
//                        description = "Client’s menu was last modified",
//                    ),
//                ),
//            actions =
//                listOf(
//                    ClientActionDto("Activate", "activate_client", true),
//                    ClientActionDto("Delete", "delete_client", true),
//                    ClientActionDto("Export Client Data", "export_client_data", true),
//                ),
//        )
//    }
//}
