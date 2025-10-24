package com.example.qrbnb_superadmin.navigation

import com.example.qrbnb_superadmin.data.TokenStorage

class AuthStatusChecker(private val tokenStorage: TokenStorage) {

    fun getStartDestination():String{
        val token=tokenStorage.getToken()
        if(token!=null && token.isNotEmpty()){
            return ScreenRoutes.CLIENT_OVERVIEW
        }else{
            return ScreenRoutes.LOGIN
        }
    }
}