package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.service.ClientOverviewDataSource

import com.example.qrbnb_superadmin.data.remote.service.RealClientOverviewDataSource
import com.example.qrbnb_superadmin.data.repository.ClientRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientsOverviewUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientsOverviewViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val clientModule =
    module {
        single<ClientOverviewDataSource> {
            RealClientOverviewDataSource(httpClient = get(POST_LOGIN_CLIENT), baseUrl = get(named("BASE_URL")))
//            FakeClientDataSource() // Use fake for now

        }
        single<ClientRepository> { ClientRepositoryImpl(get()) }
        factory { GetClientsOverviewUseCase(get()) }
        factory { GetClientsUseCase(get()) }
        factory { ClientsOverviewViewModel(get(), get()) }
    }
