package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.service.AddNewClientDataSource
import com.example.qrbnb_superadmin.data.remote.service.FakeAddClientDataSource
import com.example.qrbnb_superadmin.data.remote.service.RealAddNewClientDataSource

import com.example.qrbnb_superadmin.data.repository.NewClientRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.NewClientRepository
import com.example.qrbnb_superadmin.domain.usecase.GetAddClientFormUseCase
import com.example.qrbnb_superadmin.domain.usecase.SubmitAddClientFormUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientFormViewModel
import org.koin.dsl.module


val AddNewClientScreenModule= module {

    single<AddNewClientDataSource> {
//        FakeAddClientDataSource()
        RealAddNewClientDataSource(httpClient = get(POST_LOGIN_CLIENT))
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