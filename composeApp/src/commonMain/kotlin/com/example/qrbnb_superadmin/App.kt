package com.example.qrbnb_superadmin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R


import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.screen.AddClientScreen
import com.example.qrbnb_superadmin.presentation.screen.ClientDetailsScreen
import com.example.qrbnb_superadmin.presentation.screen.ClientsOverviewScreen

import com.example.qrbnb_superadmin.presentation.screen.LoginScreen
import com.example.qrbnb_superadmin.presentation.screen.QRBnBSuperadminLoginScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.compose_multiplatform



@Composable
@Preview
fun App() {
    MaterialTheme {
//        ClientsOverviewScreen(onClientClick = {}, onAddClientClick = {})
//        ClientDetailsScreen(onNavigateBack = {})
//        QRBnBSuperadminLoginScreen()

        AddClientScreen(

            onBackClick ={},
            onSaveClick = {}
        )


    }
}