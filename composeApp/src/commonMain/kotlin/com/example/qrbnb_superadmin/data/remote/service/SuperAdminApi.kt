package com.example.qrbnb_superadmin.data.remote.service

import com.example.qrbnb_superadmin.data.remote.model.ApiResponse
import com.example.qrbnb_superadmin.data.remote.model.LoginDataDto

interface SuperadminApi {
    suspend fun login(request: LoginRequest): ApiResponse<LoginDataDto>
}
