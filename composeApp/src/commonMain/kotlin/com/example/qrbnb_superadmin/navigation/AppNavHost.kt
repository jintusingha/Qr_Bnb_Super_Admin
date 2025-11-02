package com.example.qrbnb_superadmin.navigation

import OrderDetailsScreen
import OrdersOverviewScreen
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
import com.example.qrbnb_superadmin.presentation.screen.OrdersScreen
import com.example.qrbnb_superadmin.presentation.screen.QRBnBSuperadminLoginScreen

@Composable
fun AppNavHost(authStatusChecker: AuthStatusChecker) {
    val initialRoute = authStatusChecker.getStartDestination()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = initialRoute,
    ) {
        composable(ScreenRoutes.Login.route) {
            QRBnBSuperadminLoginScreen(
                onLoginSuccess = {
                    navController.navigate(ScreenRoutes.ClientOverview.route) {
                        popUpTo(ScreenRoutes.Login.route) { inclusive = true }
                    }
                },
            )
        }

        composable(ScreenRoutes.ClientOverview.route) {
            ClientsOverviewScreen(
                onClientClick = { clientId ->
                    Logger.d("AppNavHost", "Navigating to details screen with ID: $clientId")
                    navController.navigate(ScreenRoutes.ClientDetails(clientId).route)
                },
                onAddClientClick = {
                    navController.navigate(ScreenRoutes.ClientAdd.route)
                },
                onTotalClientsClick = {
                    navController.navigate(ScreenRoutes.OrdersOverview.route)
                },
            )
        }

        composable(
            route = ScreenRoutes.ClientDetails.ROUTE_WITH_ARGS,
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

        composable(ScreenRoutes.ClientAdd.route) {
            AddClientScreen(onBackClick = {
                navController.navigate(ScreenRoutes.ClientOverview.route)
            })
        }

        composable(ScreenRoutes.OrdersOverview.route) {
            OrdersOverviewScreen(onBackClick = {
                navController.navigate(ScreenRoutes.ClientOverview.route)
            },onClientClick = { clientId ->
                navController.navigate(ScreenRoutes.Orders(clientId).route)
            })
        }

        composable(
            route = ScreenRoutes.Orders.ROUTE_WITH_ARGS,
            arguments = listOf(
                navArgument("clientId") { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val clientId = backStackEntry.arguments?.getString("clientId")
            if (clientId != null) {
                OrdersScreen(
                    clientId = clientId,
                    onBackClick = {
                        navController.navigate(ScreenRoutes.OrdersOverview.route)
                    },onOrderClick = { orderId ->
                        navController.navigate(ScreenRoutes.OrderDetails(orderId).route)
                    }
                )
            }
        }
        composable(
            route = ScreenRoutes.OrderDetails.ROUTE_WITH_ARGS,
            arguments = listOf(
                navArgument("orderId") { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")

            if (orderId != null) {
                OrderDetailsScreen(
                    orderId = orderId,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

    }
}
