package com.example.qrbnb_superadmin.di


import com.example.qrbnb_superadmin.data.remote.service.OrderListDataSource
import com.example.qrbnb_superadmin.data.remote.service.RealOrderListDataSource
import com.example.qrbnb_superadmin.data.repository.OrderListRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.OrderListRepository
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.OrderListViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val OrdersModule= module {
    single<OrderListDataSource>{
        RealOrderListDataSource(get(POST_LOGIN_CLIENT), baseUrl = get(named("BASE_URL_ORDER_LIST")))

//        FakeOrderListDataSource()
    }
    single<OrderListRepository>{
        OrderListRepositoryImpl(datasource = get())

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

