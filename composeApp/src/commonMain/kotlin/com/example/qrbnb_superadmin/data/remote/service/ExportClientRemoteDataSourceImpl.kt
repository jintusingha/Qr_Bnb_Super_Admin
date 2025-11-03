package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDataDto
import com.example.qrbnb_superadmin.data.remote.model.exportClientDto.ExportClientDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class ExportClientRemoteDataSourceImpl(
    private val httpClient: HttpClient,
    val baseUrl: String,
) : ExportClientRemoteDataSource {
    private val TAG = "ExportClientRemoteDataSource"

    override suspend fun exportClient(clientId: String): ExportClientDto {
        val url = "$baseUrl/clients/$clientId/export"
        Logger.d(TAG, "Making post request to $url")

        return try {
            val response = httpClient.post(url)
            Logger.d(TAG, "Response status : ${response.status}")
            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet: ${bodyText.take(200)}..")

            if (response.status.isSuccess()) {
                val result = response.body<ExportClientDto>()
                Logger.d(TAG, "Client data export Successfull: ${result.message}")
                result
            } else {
                val errorMessage = "API call failed with status:${response.status}"
                Logger.e(TAG, errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "Export client api call faild:${e.message}")
            throw e
        }
    }
}
