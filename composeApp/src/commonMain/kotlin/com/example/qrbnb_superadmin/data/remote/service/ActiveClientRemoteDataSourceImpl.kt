package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ActivateClientResponseDto.ActivateClientResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class ActivateClientRemoteDataSourceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String,
) : ActivateClientRemoteDataSource {
    private val TAG = "ActivateClientRemoteDataSourceImpl"

    override suspend fun activateClient(clientId: String): ActivateClientResponseDto {
        val url = "$baseUrl/clients/$clientId/activate"
        Logger.d(TAG, "Making POST request to: $url")

        return try {
            val response = httpClient.patch(url)
            Logger.d(TAG, "Response status: ${response.status}")

            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet: ${bodyText.take(200)}...")

            if (response.status.isSuccess()) {
                val result = response.body<ActivateClientResponseDto>()
                Logger.d(TAG, "Client activation successful: ${result.message}")
                result
            } else {
                val errorMessage = "API call failed with status: ${response.status}"
                Logger.e(TAG, errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "activateClient API call failed: ${e.message}")
            throw e
        }
    }
}
