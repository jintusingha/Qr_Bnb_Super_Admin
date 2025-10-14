package com.example.qrbnb_superadmin.di



import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.data.remote.FakeSuperadminApi
import com.example.qrbnb_superadmin.data.remote.SuperadminApi

import com.example.qrbnb_superadmin.data.repository.SuperadminRepositoryImpl
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel
import org.koin.dsl.module

// This module groups all the definitions for the Login feature and its dependencies.
val appModule = module {


    single<SuperadminApi> {
        //  Replace this line with 'RealSuperadminApi(get())' when the backend is ready.
        FakeSuperadminApi()
    }





    // --- Data/Domain Layer Definitions ---

    // 1. Repository: Defined as a SINGLETON (single).
    // The same instance is reused across the entire app.
    single<SuperadminRepository> {
        SuperadminRepositoryImpl(api=get())
    }

    // 2. Use Case: Defined as a FACTORY.
    // It's lightweight, but defining as single is also common. Let's use FACTORY for now.
    factory {
        LoginUseCase(repository = get()) // 'get()' automatically finds the SuperadminRepository
    }

    // --- Presentation Layer Definitions ---

    // 3. ViewModel: Defined as a FACTORY.
    // We want a new, fresh ViewModel instance every time the screen asks for one.
    factory {
        LoginViewModel(loginUseCase = get(),
            toastManager = get())
    }

}

// The core function to start Koin
fun initKoin() = org.koin.core.context.startKoin {
    // Load all defined modules
    modules(appModule,platformModule,clientModule)
}

