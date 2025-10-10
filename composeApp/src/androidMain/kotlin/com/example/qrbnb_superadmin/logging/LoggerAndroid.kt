package com.example.qrbnb_superadmin.logging

import android.util.Log


actual object Logger {
    actual fun d(tag: String, message: String): Unit {
        Log.d(tag, message)
    }

    actual fun e(tag: String, message: String): Unit {
        Log.e(tag, message)
    }
}