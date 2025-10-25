package com.example.qrbnb_superadmin.data

import android.content.Context

class AndroidTokenStorage(
    context: Context,
) : TokenStorage {
    private val prefs = context.getSharedPreferences("superadminprefs", Context.MODE_PRIVATE)
    private val tokenKey = "ACCESS_TOKEN"

    override fun saveToken(token: String) {
        prefs.edit().putString(tokenKey, token).apply()
    }

    override fun getToken(): String? = prefs.getString(tokenKey, null)

    override fun clearToken() {
        prefs.edit().remove(tokenKey).apply()
    }
}
