package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class RealClientOverviewDataSource (private val httpClient: HttpClient,val baseUrl:String): ClientOverviewDataSource {


    private val TAG = "RealClientDataSource"
    override suspend fun getClients(): ClientsResponseDto {
        return try{
            val clientsUrl="$baseUrl/dashboard"
            Logger.d(TAG, "Making GET request to: $clientsUrl")
            val response=httpClient.get(clientsUrl)
            Logger.d(TAG, "Response status: ${response.status}")
            val bodyText=response.bodyAsText()
            Logger.d(TAG, "Response body snippet: ${bodyText.take(150)}...")
            val apiResponse=response.body<ClientsResponseDto>()
            Logger.d(TAG, "Parsed response - success: ${apiResponse.success}")
            apiResponse

        }catch(e: Exception){
            Logger.e(TAG, "getClients API call failed: ${e.message}", )
            throw e
        }

    }
}