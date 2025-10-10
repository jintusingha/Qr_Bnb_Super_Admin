package com.example.qrbnb_superadmin.domain.exception

class InvalidCredentialsException(
    message: String = "Invalid credentials provided."
) : Exception(message)