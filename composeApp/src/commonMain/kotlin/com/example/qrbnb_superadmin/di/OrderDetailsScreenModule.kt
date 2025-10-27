package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.data.remote.service.FakeOrderDataSource
import com.example.qrbnb_superadmin.data.remote.service.OrderDataSource
import com.example.qrbnb_superadmin.data.repository.OrderRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.OrderRepository
import com.example.qrbnb_superadmin.domain.usecase.GetOrderDetailsUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.OrderDetailsViewModel
import org.koin.dsl.module

val OrderDetailsScreenModule = module {

    // 1. Data Source (The implementation of the network contract)
    // We bind the interface to the Fake implementation for development/testing.
    single<OrderDataSource> {
        FakeOrderDataSource()
    }

    // 2. Repository (The contract implementation)
    // It depends on the Data Source (get()) and the Mapper (toDomain function).
    // Note: If the mapper were a class, we would inject it here as well.
    single<OrderRepository> {
        OrderRepositoryImpl(dataSource = get())
    }

    // 3. Use Case (The business logic layer)
    // Factory is appropriate for Use Cases as they are transactional and can be transient.
    factory {
        GetOrderDetailsUseCase(repository = get())
    }

    // 4. ViewModel (The Presentation layer)
    // Factory is usually appropriate for ViewModels as the Android system manages their lifecycle.
    factory {
        OrderDetailsViewModel(
            getOrderDetailsUseCase = get()
        )
    }
}