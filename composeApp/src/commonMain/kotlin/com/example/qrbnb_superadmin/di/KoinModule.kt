package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.TokenStorage
import com.example.qrbnb_superadmin.data.remote.model.RefreshRequest
import com.example.qrbnb_superadmin.data.remote.model.RefreshResponse
import com.example.qrbnb_superadmin.data.remote.service.RealSuperadminApi
import com.example.qrbnb_superadmin.data.remote.service.SuperadminApi
import com.example.qrbnb_superadmin.data.repository.SuperadminRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.navigation.AuthStatusChecker
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val PRE_LOGIN_CLIENT = named("preLoginClient")
val POST_LOGIN_CLIENT = named("postLoginClient")

val appModule =
    module {

        single(POST_LOGIN_CLIENT) {
            val tokenStorage: TokenStorage = get()
            val baseUrl: String = get(named("BASE_URL"))

            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        },
                    )
                }
                install(Logging) { level = LogLevel.BODY }
                expectSuccess = true

                install(Auth) {
                    bearer {

                        loadTokens {
                            tokenStorage.getAccessToken()?.let { accessToken ->
                                BearerTokens(accessToken, "")
                            }
                        }

                        refreshTokens {
                            val refreshToken = tokenStorage.getRefreshToken()
                            if (refreshToken != null) {

                                Logger.d("AuthDebug", "Refreshing token using: $refreshToken")
                                Logger.d("AuthDebug", "Calling refresh endpoint: $baseUrl/refresh")
                                val response: HttpResponse =
                                    client.post("$baseUrl/refresh") {
                                        markAsRefreshTokenRequest()
                                        contentType(ContentType.Application.Json)
                                        setBody(RefreshRequest(refreshToken))
                                    }

                                if (response.status == HttpStatusCode.OK || response.status == HttpStatusCode.Created) {
                                    val body: RefreshResponse = response.body()

                                    if (body.success) {
                                        val newAccessToken = body.data.accessToken
                                        val newRefreshToken = body.data.refreshToken
                                        Logger.d("AuthDebug", "Token refreshed successfully!")
                                        Logger.d("AuthDebug", "New access token: $newAccessToken")
                                        Logger.d("AuthDebug", "New refresh token: $newRefreshToken")

                                        tokenStorage.saveTokens(newAccessToken, newRefreshToken)

                                        BearerTokens(newAccessToken, newRefreshToken)
                                    } else {

                                        tokenStorage.clearTokens()
                                        null
                                    }
                                } else {

                                    tokenStorage.clearTokens()
                                    null
                                }
                            } else {
                                null
                            }
                        }
                    }
                }
            }
        }

        single(PRE_LOGIN_CLIENT) {
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        },
                    )
                }
                install(Logging) { level = LogLevel.BODY }
                expectSuccess = true
            }
        }

        single<SuperadminApi> {
            RealSuperadminApi(httpClient = get(PRE_LOGIN_CLIENT), baseUrl = get(named("BASE_URL")))
        }

        single<SuperadminRepository> {
            SuperadminRepositoryImpl(api = get())
        }

        single {
            AuthStatusChecker(tokenStorage = get())
        }

        factory {
            LoginUseCase(repository = get(), tokenStorage = get())
        }

        factory {
            LoginViewModel(loginUseCase = get(), toastManager = get())
        }
    }
