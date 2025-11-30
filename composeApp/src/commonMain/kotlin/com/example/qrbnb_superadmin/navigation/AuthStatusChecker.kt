package com.example.qrbnb_superadmin.navigation

import com.example.qrbnb_superadmin.data.TokenStorage

class AuthStatusChecker(private val tokenStorage: TokenStorage) {

    fun getStartDestination(): String {
        val accessToken = tokenStorage.getAccessToken()
        return if (!accessToken.isNullOrEmpty()) {

            ScreenRoutes.ClientOverview.route
        } else {

            ScreenRoutes.Login.route
        }
    }
}
