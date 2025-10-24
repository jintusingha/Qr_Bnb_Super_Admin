package com.example.qrbnb_superadmin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrbnb_superadmin.presentation.screen.ClientsOverviewScreen
import com.example.qrbnb_superadmin.presentation.screen.QRBnBSuperadminLoginScreen


@Composable
fun AppNavHost(
    authStatusChecker: AuthStatusChecker
){
    val initialRoute=authStatusChecker.getStartDestination()
    val navController= rememberNavController()

    NavHost(
        navController=navController,
        startDestination = initialRoute
    ){
        composable(ScreenRoutes.LOGIN){
            QRBnBSuperadminLoginScreen(
                onLoginSuccess = {
                    navController.navigate(ScreenRoutes.CLIENT_OVERVIEW){
                        popUpTo(ScreenRoutes.LOGIN) { inclusive=true}
                    }
                }
            )



        }
        composable(ScreenRoutes.CLIENT_OVERVIEW){
            ClientsOverviewScreen(onClientClick = {}, onAddClientClick = {})
        }
    }
}