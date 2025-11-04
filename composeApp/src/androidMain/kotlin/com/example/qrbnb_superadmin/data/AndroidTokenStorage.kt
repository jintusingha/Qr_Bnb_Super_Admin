package com.example.qrbnb_superadmin.data

import android.content.Context

class AndroidTokenStorage(
    context: Context,
) : TokenStorage {

    private val prefs = context.getSharedPreferences("superadminprefs", Context.MODE_PRIVATE)

    private val accessTokenKey = "ACCESS_TOKEN"
    private val refreshTokenKey = "REFRESH_TOKEN"

    override fun saveTokens(accessToken: String, refreshToken: String) {
        prefs.edit()
            .putString(accessTokenKey, accessToken)
            .putString(refreshTokenKey, refreshToken)
            .apply()
    }

    override fun getAccessToken(): String? = prefs.getString(accessTokenKey, null)

    override fun getRefreshToken(): String? = prefs.getString(refreshTokenKey, null)

    override fun clearTokens() {
        prefs.edit()
            .remove(accessTokenKey)
            .remove(refreshTokenKey)
            .apply()
    }
}