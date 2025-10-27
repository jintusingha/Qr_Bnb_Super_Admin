package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.FormSchemaResponse
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess

class RealAddNewClientDataSource(
    private val httpClient: HttpClient,
) : AddNewClientDataSource {
    private val BASE_URL = "https://qrbnb.onrender.com/superadmin"
    private val TAG = "RealAddNewClientDataSource"

    override suspend fun getAddClientFormSchema(): FormSchemaResponse {
        val formSchemaUrl = "$BASE_URL/forms/add-client"
        Logger.d(TAG, "Making GET request for client form schema to: $formSchemaUrl")
        return try {
            val response = httpClient.get(formSchemaUrl)
            Logger.d(TAG, "Response status for schema: ${response.status}")
            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet for schema: ${bodyText.take(200)}...")
            if (response.status.isSuccess()) {
                response.body<FormSchemaResponse>()
            } else {
                val errorMessage = "API call failed with status:${response.status}for form schema"
                Logger.e(TAG, errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "getAddClientFormSchema API call failed: ${e.message}")
            throw e
        }
    }

    override suspend fun submitAddClientForm(formValues: Map<String, Any>): AddClientResponseDto {
        TODO("Not yet implemented")
    }


}
