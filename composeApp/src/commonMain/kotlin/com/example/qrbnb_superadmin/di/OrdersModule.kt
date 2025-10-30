package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.service.FakeOrdersDataSource
import com.example.qrbnb_superadmin.data.remote.service.OrdersDataSource
import com.example.qrbnb_superadmin.data.repository.OrdersRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.OrdersRepository
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.OrdersViewModel
import org.koin.dsl.module


val OrdersModule= module {
    single<OrdersDataSource>{
        FakeOrdersDataSource()
    }
    single<OrdersRepository>{
        OrdersRepositoryImpl(datasource = get())

    }
    factory {
        GetOrdersUseCase(repository = get())
    }
    factory {
        OrdersViewModel(
            getOrdersUseCase = get()
        )
    }
}

