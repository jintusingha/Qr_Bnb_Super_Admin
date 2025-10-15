package com.example.qrbnb_superadmin.domain.entity

data class ClientDetails(
    val client: ClientInfo,
    val activityOverview: ActivityOverview,
    val timeline:List<TimelineEvent>,
    val actions:List<ClientAction>
)



data class ClientAction(
    val label:String,
    val action:String,
    val enabled:Boolean
)

data class TimelineEvent(
    val title:String,
    val date:String,
    val description:String
)

data class ActivityOverview(
    val ordersPlaced:Int,
    val itemsCreated:Int,
    val categoriesCount:Int,
    val lastLogin:String
)

data class ClientInfo(
    val clientId:Int,
    val name:String,
    val email:String,
    val phone:String,
    val avatarUrl:String,
    val registrationDate:String,
    val subscriptionStatus:String

)