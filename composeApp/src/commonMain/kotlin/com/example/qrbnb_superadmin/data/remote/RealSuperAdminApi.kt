package com.example.qrbnb_superadmin.data.remote

import com.example.qrbnb_superadmin.data.remote.model.ApiResponse
import com.example.qrbnb_superadmin.data.remote.model.LoginDataDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RealSuperadminApi(
    private val httpClient: HttpClient
) : SuperadminApi {

    private val BASE_URL = "https://qrbnb.onrender.com/superadmin"

    override suspend fun login(request: LoginRequest): ApiResponse<LoginDataDto> {
        return try {
            val loginUrl = "$BASE_URL/login"
            Logger.d("RealSuperadminApi", "Making login request to: $loginUrl")
            Logger.d("RealSuperadminApi", "Request: email=${request.email}")

            val response = httpClient.post(loginUrl) {
                contentType(ContentType.Application.Json)
                setBody(request)
            }

            Logger.d("RealSuperadminApi", "Response status: ${response.status}")

            val bodyText = response.bodyAsText()
            Logger.d("RealSuperadminApi", "Response body: $bodyText")


            val apiResponse = response.body<ApiResponse<LoginDataDto>>()
            Logger.d("RealSuperadminApi", "Parsed response - success: ${apiResponse.success}")

            apiResponse

        } catch (e: Exception) {
            Logger.e("RealSuperadminApi", "Login API call failed: ${e.message}")


            ApiResponse(
                success = false,
                message = "Network error: ${e.message ?: "Unknown error"}",
                errorCode = "NETWORK_ERROR",
                data = null
            )
        }
    }
}