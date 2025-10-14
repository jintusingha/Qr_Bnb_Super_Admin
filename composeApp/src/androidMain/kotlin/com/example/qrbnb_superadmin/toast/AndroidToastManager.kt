package com.example.qrbnb_superadmin.toast

import android.content.Context
import android.widget.Toast

class AndroidToastManager(private val context: Context) : ToastManager {
    override fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}