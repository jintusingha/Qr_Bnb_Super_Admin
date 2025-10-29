package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ordersoverviewDto.OrdersOverviewResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class RealOrdersOverviewDataSource(
    private val httpClient: HttpClient,
) : OrdersOverviewDataSource {
    private val BASE_URL = "https://qrbnb.onrender.com/superadmin"
    private val TAG = "RealOrdersOverviewDataSource"

    override suspend fun getOrdersOverviewData(): OrdersOverviewResponseDto {
        val ordersOverviewUrl = "$BASE_URL/orders/overview"

        Logger.d(TAG, "Making GET request for Orders Overview to: $ordersOverviewUrl")

        return try {
            val response = httpClient.get(ordersOverviewUrl)

            Logger.d(TAG, "Response status: ${response.status}")

            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet: ${bodyText.take(200)}...")

            if (response.status.isSuccess()) {
                val ordersOverviewResponse = response.body<OrdersOverviewResponseDto>()
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
