package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.DeleteClientResponseDto.DeleteClientResponseDto
import com.example.qrbnb_superadmin.logging.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class DeleteClientRemoteDataSourceImpl (private val httpClient: HttpClient,private val baseUrl:String): DeleteClientRemoteDataSource{
    private val TAG="DeleteClientRemoteDataSourceImpl"
    override suspend fun deleteClient(clientId: String): DeleteClientResponseDto {

        val url="$baseUrl/clients/$clientId"
        Logger.d(TAG,"Making post request to :$url")

        return try{
            val response=httpClient.post(url)
            Logger.d(TAG,"Response status:${response.status}")
            val bodyText=response.bodyAsText()
            Logger.d(TAG,"Response body snipper:${bodyText.take(200)}..")
            if(response.status.isSuccess()){
                val result=response.body<DeleteClientResponseDto>()
                Logger.d(TAG,"Client deletion successfull:${result.message}")
                result
            }else{
                val errorMessage="API call failed with status:${response.status}"
                Logger.e(TAG,errorMessage)
                throw Exception(errorMessage)
            }

        }catch (e: Exception){
            Logger.e(TAG,"delete client api call failed:${e.message}")
            throw e
        }

    }

}