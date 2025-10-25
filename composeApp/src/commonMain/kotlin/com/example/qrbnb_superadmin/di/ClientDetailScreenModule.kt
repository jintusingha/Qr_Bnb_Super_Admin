package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.ClientDetailsDataSource
import com.example.qrbnb_superadmin.data.remote.FakeClientDetailsDataSource
import com.example.qrbnb_superadmin.data.repository.ClientDetailsRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import org.koin.dsl.module

val ClientDetailsScreenModule =
    module {
        single<ClientDetailsDataSource> {
            FakeClientDetailsDataSource()
        }

        single<ClientDetailsRepository> { ClientDetailsRepositoryImpl(get()) }

        factory { GetClientDetailsUseCase(repository = get()) }

        factory { ClientDetailsViewModel(get()) }
    }
