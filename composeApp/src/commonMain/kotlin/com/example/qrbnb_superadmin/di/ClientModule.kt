package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.ClientDataSource
import com.example.qrbnb_superadmin.data.remote.FakeClientDataSource
import com.example.qrbnb_superadmin.data.repository.ClientRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientsOverviewUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientsOverviewViewModel
import org.koin.dsl.module

val clientModule =
    module {
        single<ClientDataSource> {
            FakeClientDataSource() // Use fake for now

        }
        single<ClientRepository> { ClientRepositoryImpl(get()) }
        factory { GetClientsOverviewUseCase(get()) }
        factory { GetClientsUseCase(get()) }
        factory { ClientsOverviewViewModel(get(), get()) }
    }
