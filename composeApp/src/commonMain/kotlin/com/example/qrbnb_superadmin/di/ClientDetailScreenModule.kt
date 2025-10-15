package com.example.qrbnb_superadmin.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.repository.FakeClientDetailsRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.ClientDetailsRepository
import com.example.qrbnb_superadmin.domain.usecase.GetClientDetailsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import org.koin.dsl.module

val ClientDetailsScreenModule =
    module {

        single<ClientDetailsRepository> { FakeClientDetailsRepositoryImpl() }

        factory { GetClientDetailsUseCase(repository = get()) }

        factory { ClientDetailsViewModel(get()) }
    }
