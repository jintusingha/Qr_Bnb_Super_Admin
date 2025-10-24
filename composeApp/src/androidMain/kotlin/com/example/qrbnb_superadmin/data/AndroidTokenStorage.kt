package com.example.qrbnb_superadmin.data

import android.content.Context


class AndroidTokenStorage (context: Context): TokenStorage{
    private val prefs=context.getSharedPreferences("superadminprefs",Context.MODE_PRIVATE)
    private val Token_Key="ACCESS_TOKEN"


    override fun saveToken(token: String) {
        prefs.edit().putString(Token_Key,token).apply()

    }

    override fun getToken(): String? {
        return prefs.getString(Token_Key,null)

    }

    override fun clearToken() {
        prefs.edit().remove(Token_Key).apply()

    }

}