package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class RealOrdersOverviewDataSource(
    private val httpClient: HttpClient,
    val baseUrl: String,
) : OrdersOverviewDataSource {
    private val TAG = "RealOrdersOverviewDataSource"

    override suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto {
        val ordersOverviewUrl = "$baseUrl/orders/overview"

        Logger.d(TAG, "Making GET request for Orders Overview to: $ordersOverviewUrl")

        return try {
            val response = httpClient.get(ordersOverviewUrl)

            Logger.d(TAG, "Response status: ${response.status}")

            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet: ${bodyText.take(200)}...")

            if (response.status.isSuccess()) {
                val ordersOverviewResponse = response.body<OrdersOverviewResponseDto>()
                // <<<<-------the below is to check the client id ------>>>>>
                val clientlist = ordersOverviewResponse.data.clientPerformance
                clientlist.forEach { client ->
                    Logger.d("JUST CHECKING", "CLIENT ID:${client.id},Name:${client.name}")
                }
                Logger.d(TAG, "Successfully parsed Orders Overview data")
                ordersOverviewResponse
            } else {
                val errorMessage = "API call failed with status: ${response.status} and body: $bodyText"
                Logger.e(TAG, errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "getOrdersOverviewData API call failed: ${e.message}")
            throw e
        }
    }
}
