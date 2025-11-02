package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.clientsDetailsDto.ClientDetailsResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class RealClientDetailsDataSource(
    private val httpClient: HttpClient,
    val baseUrl: String,
) : ClientDetailsDataSource {
    private val TAG = "RealClientDetailsDataSource"

    override suspend fun getClientDetails(clientId: String): ClientDetailsDto {
        val clientDetailsUrl = "$baseUrl/clients/$clientId"

        Logger.d(TAG, "Making GET request for client details to: $clientDetailsUrl")

        return try {
            val response = httpClient.get(clientDetailsUrl)

            Logger.d(TAG, "Response status for client $clientId: ${response.status}")

            val bodyText = response.bodyAsText()

            Logger.d(TAG, "Response body snippet for client $clientId: ${bodyText.take(200)}...")

            if (response.status.isSuccess()) {
                val clientDetailsResponse = response.body<ClientDetailsResponseDto>()
                val clientDetailsDto = clientDetailsResponse.data
                Logger.d(TAG, "Successfully parsed details for client: ${clientDetailsDto.profile.name}")
                clientDetailsDto
            } else {
                val errorMessage = "API call failed with status: ${response.status} and body: $bodyText"
                Logger.e(TAG, errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "getClientDetails API call failed for ID $clientId: ${e.message}")
            throw e
        }
    }
}
