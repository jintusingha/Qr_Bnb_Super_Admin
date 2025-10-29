package com.example.qrbnb_superadmin.di

import androidx.lifecycle.ViewModelProvider
import com.example.qrbnb_superadmin.data.remote.service.OrdersOverviewDataSource
import com.example.qrbnb_superadmin.data.remote.service.OrdersOverviewDummyDataSource
import com.example.qrbnb_superadmin.data.remote.service.RealOrdersOverviewDataSource
import com.example.qrbnb_superadmin.data.repository.OrdersOverviewRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.OrdersOverviewRepository
import com.example.qrbnb_superadmin.domain.usecase.GetOrdersOverviewUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.OrdersOverviewViewModel
import org.koin.dsl.module

val OrdersOverviewModule =
    module {

        single<OrdersOverviewDataSource> {
//            OrdersOverviewDummyDataSource()
            RealOrdersOverviewDataSource(httpClient = get(POST_LOGIN_CLIENT))
        }

        single<OrdersOverviewRepository> {
            OrdersOverviewRepositoryImpl(get())
        }
        factory {
            GetOrdersOverviewUseCase(
                repository = get(),
            )
        }
        factory {
            OrdersOverviewViewModel(
                getOrdersOverviewUseCase = get(),
            )
        }
    }
