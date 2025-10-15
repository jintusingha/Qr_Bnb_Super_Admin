package com.example.qrbnb_superadmin

import android.app.Application
import com.example.qrbnb_superadmin.di.ClientDetailsScreenModule
import com.example.qrbnb_superadmin.di.appModule
import com.example.qrbnb_superadmin.di.clientModule
import com.example.qrbnb_superadmin.di.platformModule
// The imports for the Koin Android extensions are critical:
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class SuperadminApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // We bypass the simple shared initKoin() and call the full Koin startup
        // to properly configure the Android environment.
        startKoin {
            // 1. Configure Koin logging using the Android logger
            androidLogger(Level.ERROR)

            // 2. Pass the Application Context to Koin
            // 'this@SuperadminApplication' refers to the Application object, which is a Context.
            androidContext(this@SuperadminApplication)

            // 3. Load your shared module
            modules(appModule, platformModule, clientModule, ClientDetailsScreenModule)
        }
    }
}
