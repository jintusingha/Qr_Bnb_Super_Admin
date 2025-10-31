package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderResponseDto
import com.example.qrbnb_superadmin.logging.Logger.e
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess


class RealOrderDataSource (private val httpClient: HttpClient): OrderDataSource {
    private val BASE_URL="https://qrbnb.onrender.com/superadmin"
    override suspend fun fetchOrderDetails(orderId: String): OrderDetailsDto {
        val orderdetailsurl="$BASE_URL/orders/$orderId"

        return try{
            val response=httpClient.get(orderdetailsurl)
            val bodyText=response.bodyAsText()
            if(response.status.isSuccess()){
                val orderdetailsResponse=response.body<OrderResponseDto>()
                val orderdetailsDto=orderdetailsResponse.data
                orderdetailsDto
            }else{
                val errorMessage="api call failed with status ${response.status} and body:${bodyText}"
                throw Exception(errorMessage)

            }
        }catch (e: Exception){
            throw e
        }

    }
}