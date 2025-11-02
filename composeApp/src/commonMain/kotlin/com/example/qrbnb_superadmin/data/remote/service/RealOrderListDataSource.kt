package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderListDto.OrderListResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText

class RealOrderListDataSource(
    private val httpClient: HttpClient,
    private val baseUrl: String,
) : OrderListDataSource {
    private val TAG = "RealOrderListDataSource"

    override suspend fun getOrderListData(
        clientId: String,
        status: String?,
    ): OrderListResponseDto =
        try {
            val ordersUrl = "$baseUrl/orders"

            Logger.d(TAG, "Making GET request to: $ordersUrl with clientId=$clientId, status=$status")
            val response =
                httpClient.get(ordersUrl) {
                    parameter("clientId", clientId)
                    status?.let { parameter("status", it) }
                }
            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response status: ${response.status}")
            Logger.d(TAG, "Response body snippet: ${bodyText.take(200)}")
            val apiResponse = response.body<OrderListResponseDto>()
            Logger.d(TAG, "Parsed response - success: ${apiResponse.success}")
            Logger.d(TAG, "THE ID IS ${apiResponse.data.orders.first().clientId}")
            apiResponse
        } catch (e: Exception) {
            Logger.e(TAG, "getOrderListData API call failed: ${e.message}")
            throw e
        }
}
