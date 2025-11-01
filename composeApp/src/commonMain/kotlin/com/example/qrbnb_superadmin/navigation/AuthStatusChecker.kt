package com.example.qrbnb_superadmin.navigation

import com.example.qrbnb_superadmin.data.TokenStorage

class AuthStatusChecker(private val tokenStorage: TokenStorage) {

    fun getStartDestination(): String {
        val token = tokenStorage.getToken()
        return if (token != null && token.isNotEmpty()) {
            ScreenRoutes.ClientOverview.route
        } else {
            ScreenRoutes.Login.route
        }
    }
}