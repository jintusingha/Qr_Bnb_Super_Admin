package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.clientsoverviewDto.ClientsResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText


class RealClientDataSource (private val httpClient: HttpClient): ClientDataSource{

    private val BASE_URL="https://qrbnb.onrender.com/superadmin"
    private val TAG = "RealClientDataSource"
    override suspend fun getClients(): ClientsResponseDto {
        return try{
            val clientsUrl="$BASE_URL/dashboard"
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