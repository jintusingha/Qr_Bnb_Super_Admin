package com.example.qrbnb_superadmin.logging


expect object Logger {
    fun d(tag: String, message: String)
    fun e(tag: String, message: String)
}