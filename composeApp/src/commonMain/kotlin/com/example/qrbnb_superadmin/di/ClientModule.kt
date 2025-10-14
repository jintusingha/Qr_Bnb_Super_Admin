package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.repository.FakeClientRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientsOverviewUseCase
import com.example.qrbnb_superadmin.domain.usecase.GetClientsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientsOverviewViewModel
import org.koin.dsl.module

val clientModule =
    module {
        single<ClientRepository> { FakeClientRepositoryImpl() }
        factory { GetClientsOverviewUseCase(get()) }
        factory { GetClientsUseCase(get()) }
        factory { ClientsOverviewViewModel(get(), get()) }
    }
