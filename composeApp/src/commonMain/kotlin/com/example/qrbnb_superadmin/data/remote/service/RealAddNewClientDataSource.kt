package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.AddClientResponseDto
import com.example.qrbnb_superadmin.data.remote.model.addNewClientDto.FormSchemaResponse
import com.example.qrbnb_superadmin.data.remote.model.submitFormRequest.FormValue
import com.example.qrbnb_superadmin.data.remote.model.submitFormRequest.SubmitFormRequest
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
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

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
        val submitUrl = "$BASE_URL/forms/submit"
        Logger.d(TAG, "Making POST request to submit client form to: $submitUrl")

        return try {

            val payload = SubmitFormRequest(
                formId = "add_client",
                values = formValues.map { (key, value) ->
                    FormValue(
                        id = key,
                        value = when (value) {
                            is String -> JsonPrimitive(value)
                            is Number -> JsonPrimitive(value)
                            is Boolean -> JsonPrimitive(value)
                            else -> JsonPrimitive(value.toString())
                        }
                    )
                }
            )


            Logger.d(TAG, "Submitting payload: ${Json.encodeToString(payload)}")


            val response = httpClient.post(submitUrl) {
                contentType(ContentType.Application.Json)
                setBody(payload)
            }

            Logger.d(TAG, "Response status for form submission: ${response.status}")
            val bodyText = response.bodyAsText()
            Logger.d(TAG, "Response body snippet for submission: ${bodyText.take(200)}...")

            val addClientResponse = response.body<AddClientResponseDto>()

            if (response.status.isSuccess()) {
                Logger.d(TAG, "Client form submitted successfully.")
                addClientResponse
            } else {
                val errorMessage =
                    "API call failed with status: ${response.status} for form submission"
                Logger.e(TAG, errorMessage)
                if (addClientResponse.success == true) {
                    throw Exception(errorMessage)
                }
                addClientResponse
            }
        } catch (e: Exception) {
            Logger.e(TAG, "submitAddClientForm API call failed: ${e.message}")
            throw e
        }
    }
}
