package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.service.FakeOrderListDataSource
import com.example.qrbnb_superadmin.data.remote.service.OrderListDataSource
import com.example.qrbnb_superadmin.data.repository.OrdersRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.OrderListRepository
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.OrderListViewModel
import org.koin.dsl.module


val OrdersModule= module {
    single<OrderListDataSource>{
        FakeOrderListDataSource()
    }
    single<OrderListRepository>{
        OrdersRepositoryImpl(datasource = get())

    }
    factory {
        GetOrdersUseCase(repository = get())
    }
    factory {
        OrderListViewModel(
            getOrdersUseCase = get()
        )
    }
}

