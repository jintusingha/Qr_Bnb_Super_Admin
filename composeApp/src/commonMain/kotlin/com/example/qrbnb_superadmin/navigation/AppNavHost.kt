package com.example.qrbnb_superadmin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.presentation.screen.AddClientScreen
import com.example.qrbnb_superadmin.presentation.screen.ClientDetailsScreen
import com.example.qrbnb_superadmin.presentation.screen.ClientsOverviewScreen
import com.example.qrbnb_superadmin.presentation.screen.QRBnBSuperadminLoginScreen

@Composable
fun AppNavHost(authStatusChecker: AuthStatusChecker) {
    val initialRoute = authStatusChecker.getStartDestination()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = initialRoute,
    ) {
        composable(ScreenRoutes.LOGIN) {
            QRBnBSuperadminLoginScreen(
                onLoginSuccess = {
                    navController.navigate(ScreenRoutes.CLIENT_OVERVIEW) {
                        popUpTo(ScreenRoutes.LOGIN) { inclusive = true }
                    }
                },
            )
        }
        composable(ScreenRoutes.CLIENT_OVERVIEW) {
            ClientsOverviewScreen(onClientClick = { clientId ->
                Logger.d("AppNavHost", "Navigating to details screen with ID: $clientId")
                navController.navigate(ScreenRoutes.clientDetailsPath(clientId))
            }, onAddClientClick = {
                navController.navigate(ScreenRoutes.CLIENT_ADD)
            })
        }
        composable(
            route = ScreenRoutes.CLIENT_DETAILS,
            arguments =
                listOf(
                    navArgument("clientId") { type = NavType.StringType },
                ),
        ) { backStackEntry ->
            val clientId = backStackEntry.arguments?.getString("clientId")
            if (clientId != null) {
                ClientDetailsScreen(
                    clientId = clientId,
                    onNavigateBack = { navController.popBackStack() },
                )
            }
        }
        composable(ScreenRoutes.CLIENT_ADD){
            AddClientScreen(onBackClick = { navController.navigate(ScreenRoutes.CLIENT_OVERVIEW) })
        }
    }
}
