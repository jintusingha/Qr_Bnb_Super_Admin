package com.example.qrbnb_superadmin.data.repository

import com.example.qrbnb_superadmin.domain.entity.User
import com.example.qrbnb_superadmin.domain.exception.InvalidCredentialsException
import com.example.qrbnb_superadmin.domain.repository.SuperadminRepository
import kotlinx.coroutines.delay


class SuperadminDummyRepository : SuperadminRepository {

    private val DUMMY_EMAIL = "jintu@gmail.com"
    private val DUMMY_PASSWORD = "jintusinghab@admin"
    private val DUMMY_USER_ID = "SA_1001"
    private val DUMMY_AUTH_TOKEN = "fake_jwt_token_for_sa_1001"


    override suspend fun login(email: String, password: String): User {
        delay(1000)
        if (email == DUMMY_EMAIL && password == DUMMY_PASSWORD) {


            return User(
                id = DUMMY_USER_ID,
                email = email,
                authToken = DUMMY_AUTH_TOKEN,
                )

        } else {
            throw InvalidCredentialsException("Invalid email or password.")

        }
    }
}