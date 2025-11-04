package com.example.qrbnb_superadmin.navigation

import com.example.qrbnb_superadmin.data.TokenStorage

class AuthStatusChecker(private val tokenStorage: TokenStorage) {

    fun getStartDestination(): String {
        val accessToken = tokenStorage.getAccessToken()
        return if (!accessToken.isNullOrEmpty()) {
            // ✅ If we already have a saved access token, skip login
            ScreenRoutes.ClientOverview.route
        } else {
            // ✅ If no token found, go to login screen
            ScreenRoutes.Login.route
        }
    }
}
