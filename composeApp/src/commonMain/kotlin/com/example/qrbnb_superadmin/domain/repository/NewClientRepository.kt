package com.example.qrbnb_superadmin.domain.repository

import com.example.qrbnb_superadmin.domain.entity.FormSchema

interface NewClientRepository {
    suspend fun getAddClientFormSchema(): FormSchema
}
