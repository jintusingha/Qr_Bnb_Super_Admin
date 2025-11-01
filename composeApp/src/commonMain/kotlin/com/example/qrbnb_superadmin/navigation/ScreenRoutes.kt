package com.example.qrbnb_superadmin.navigation

sealed class ScreenRoutes(
    val route: String,
) {
    object Login : ScreenRoutes("login_route")

    object ClientOverview : ScreenRoutes("client_overview_route")

    object ClientAdd : ScreenRoutes("client_add_route")

    object OrdersOverview : ScreenRoutes("orders_overview_route")

    data class ClientDetails(
        val clientId: String,
    ) : ScreenRoutes("client_details/$clientId") {
        companion object {
            const val ROUTE_WITH_ARGS = "client_details/{clientId}"
        }
    }
    data class Orders(val clientId: String) : ScreenRoutes("orders/$clientId") {
        companion object {
            const val ROUTE_WITH_ARGS = "orders/{clientId}"
        }
    }
}
