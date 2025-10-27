package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.service.ClientDetailsDataSource

import com.example.qrbnb_superadmin.data.remote.service.RealClientDetailsDataSource
import com.example.qrbnb_superadmin.data.repository.ClientDetailsRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import io.ktor.http.parameters
import org.koin.dsl.module

val ClientDetailsScreenModule =
    module {
        single<ClientDetailsDataSource> {
//            FakeClientDetailsDataSource()
            RealClientDetailsDataSource(httpClient = get(POST_LOGIN_CLIENT))
        }

        single<ClientDetailsRepository> { ClientDetailsRepositoryImpl(get()) }

        factory { GetClientDetailsUseCase(repository = get()) }

        factory { parameters -> ClientDetailsViewModel(parameters.get(),get()) }
    }
