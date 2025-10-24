package com.example.qrbnb_superadmin.data



interface TokenStorage{
    fun saveToken(token:String)
    fun getToken():String?
    fun clearToken()
}