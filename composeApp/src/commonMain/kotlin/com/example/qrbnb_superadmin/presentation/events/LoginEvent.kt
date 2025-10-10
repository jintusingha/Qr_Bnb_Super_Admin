package com.example.qrbnb_superadmin.presentation.events

sealed class LoginEvent {
    data class ShowToast(val message: String) : LoginEvent()
}
