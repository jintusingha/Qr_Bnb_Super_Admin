package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.TokenStorage
import com.example.qrbnb_superadmin.data.remote.service.RealSuperadminApi
import com.example.qrbnb_superadmin.data.remote.service.SuperadminApi
import com.example.qrbnb_superadmin.data.repository.SuperadminRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.navigation.AuthStatusChecker
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val PRE_LOGIN_CLIENT = named("preLoginClient")
val POST_LOGIN_CLIENT = named("postLoginClient")

// This module groups all the definitions for the Login feature and its dependencies.
val appModule =
    module {
        single(POST_LOGIN_CLIENT) {

            val tokenStorage: TokenStorage = get()

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

                install(io.ktor.client.plugins.auth.Auth) {

                    bearer {
                        loadTokens {

                            tokenStorage.getToken()?.let { accessToken ->

                                io.ktor.client.plugins.auth.providers
                                    .BearerTokens(accessToken, "")
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
                install(Logging) {
                    level = LogLevel.BODY
                }
                expectSuccess = true
            }
        }

        single<SuperadminApi> {

//        FakeSuperadminApi()
            RealSuperadminApi(httpClient = get(PRE_LOGIN_CLIENT), baseUrl = get(named("BASE_URL")))
        }

        single<SuperadminRepository> {
            SuperadminRepositoryImpl(api = get())
        }
        single {
            AuthStatusChecker(tokenStorage = get())
        }

        factory {
            LoginUseCase(
                repository = get(),
                tokenStorage = get(),
            ) // 'get()' automatically finds the SuperadminRepository
        }

        factory {
            LoginViewModel(
                loginUseCase = get(),
                toastManager = get(),
            )
        }
    }

// The core function to start Koin
fun initKoin() =
    org.koin.core.context.startKoin {
        // Load all defined modules
        modules(
            appModule,
            platformModule,
            clientModule,
            ClientDetailsScreenModule,
            AddNewClientScreenModule,
            OrderDetailsScreenModule,
            OrdersOverviewModule,
            OrdersModule,
            networkConfigModule,
        )
    }
