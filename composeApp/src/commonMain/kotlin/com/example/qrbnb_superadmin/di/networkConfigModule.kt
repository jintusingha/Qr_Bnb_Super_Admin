package com.example.qrbnb_superadmin.di

import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkConfigModule =
    module {
        single(named("BASE_URL_ORDER_LIST")) { "https://qrbnb.onrender.com" }
        single(named("BASE_URL")) { "https://qrbnb.onrender.com/superadmin" }
    }
