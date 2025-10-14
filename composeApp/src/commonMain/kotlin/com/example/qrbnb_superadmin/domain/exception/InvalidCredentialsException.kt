package com.example.qrbnb_superadmin.domain.exception

class InvalidCredentialsException(
    override val message: String
) : Exception(message)