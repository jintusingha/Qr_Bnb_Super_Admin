package com.example.qrbnb_superadmin.navigation


object ScreenRoutes{
    const val LOGIN="login_route"
    const val CLIENT_OVERVIEW="client_overview_route"
    const val CLIENT_DETAILS="client_details/{clientId}"
    const val CLIENT_ADD="client_add_route"

    fun clientDetailsPath(clientId:String)="client_details/$clientId"
}