package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.FakeSuperadminApi
import com.example.qrbnb_superadmin.data.remote.RealSuperadminApi
import com.example.qrbnb_superadmin.data.remote.SuperadminApi
import com.example.qrbnb_superadmin.data.repository.SuperadminRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel
import com.example.qrbnb_superadmin.presentation.viewmodel.OrdersOverviewViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

// This module groups all the definitions for the Login feature and its dependencies.
val appModule =
    module {



        single {
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
            //  Replace this line with 'RealSuperadminApi(get())' when the backend is ready.
//        FakeSuperadminApi()
            RealSuperadminApi(httpClient = get())
        }

        single<SuperadminRepository> {
            SuperadminRepositoryImpl(api = get())
        }

        factory {
            LoginUseCase(repository = get()) // 'get()' automatically finds the SuperadminRepository
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
        )
    }
