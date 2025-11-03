package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.service.ActivateClientRemoteDataSource
import com.example.qrbnb_superadmin.data.remote.service.ActivateClientRemoteDataSourceImpl
import com.example.qrbnb_superadmin.data.remote.service.ClientDetailsDataSource

import com.example.qrbnb_superadmin.data.remote.service.RealClientDetailsDataSource
import com.example.qrbnb_superadmin.data.repository.ActivateClientImpl
import com.example.qrbnb_superadmin.data.repository.ClientDetailsRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ActivateClientRepository
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository
import com.example.qrbnb_superadmin.domain.usecase.ActivateClientUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import io.ktor.http.parameters
import org.koin.core.qualifier.named
import org.koin.dsl.module

val ClientDetailsScreenModule =
    module {
        single<ClientDetailsDataSource> {
//            FakeClientDetailsDataSource()
            RealClientDetailsDataSource(httpClient = get(POST_LOGIN_CLIENT), baseUrl = get(named("BASE_URL")))
        }

        single<ClientDetailsRepository> { ClientDetailsRepositoryImpl(get()) }

        factory { GetClientDetailsUseCase(repository = get()) }
        single<ActivateClientRemoteDataSource> {
            ActivateClientRemoteDataSourceImpl(
                httpClient = get(POST_LOGIN_CLIENT),
                baseUrl = get(named("BASE_URL"))
            )
        }

        single<ActivateClientRepository> { ActivateClientImpl(get()) }
        factory { ActivateClientUseCase(repository = get()) }

        factory { parameters -> ClientDetailsViewModel(parameters.get(),get(),get()) }
    }
