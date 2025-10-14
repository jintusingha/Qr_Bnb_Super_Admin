package com.example.qrbnb_superadmin.di

import com.example.qrbnb_superadmin.toast.AndroidToastManager
import com.example.qrbnb_superadmin.toast.ToastManager
import org.koin.dsl.module

actual val platformModule = module {
    single<ToastManager> { AndroidToastManager(get()) }
}