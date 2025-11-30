package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class RealOrderDetailDataSource(
    private val httpClient: HttpClient,
    private val baseUrl: String,
) : OrderDataSource {

    override suspend fun fetchOrderDetails(orderId: String): OrderDetailsDto {
        val url = "$baseUrl/orders/$orderId"

        println("Requesting: $url")

        return try {
            val response = httpClient.get(url)

            println("Status: ${response.status}")

            val bodyText = response.bodyAsText()
            println("Response body: $bodyText")

            if (response.status.isSuccess()) {
                val dto = response.body<OrderResponseDto>()
                println("Parsed DTO: $dto")
                dto.data
            } else {
                throw Exception("API failed with status ${response.status}")
            }

        } catch (e: Exception) {
            println("Error: ${e.message}")
            throw e
        }
    }
}
