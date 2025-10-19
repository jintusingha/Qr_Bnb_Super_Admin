package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.AddNewClientDataSource
import com.example.qrbnb_superadmin.data.remote.FakeAddClientDataSource
import com.example.qrbnb_superadmin.data.remote.FakeClientDataSource
import com.example.qrbnb_superadmin.data.repository.NewClientRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.NewClientRepository
import com.example.qrbnb_superadmin.domain.usecase.GetAddClientFormUseCase
import com.example.qrbnb_superadmin.domain.usecase.SubmitAddClientFormUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientFormViewModel
import org.koin.dsl.module


val AddNewClientScreenModule= module {

    single<AddNewClientDataSource> {
        FakeAddClientDataSource()
    }

    single<NewClientRepository> {
        NewClientRepositoryImpl(get())
    }

    factory { GetAddClientFormUseCase(get()) }

    factory { SubmitAddClientFormUseCase(get()) }

    factory {
        ClientFormViewModel(
            getAddClientFormUseCase = get(),
            submitAddClientFormUseCase = get()
        )
    }




}