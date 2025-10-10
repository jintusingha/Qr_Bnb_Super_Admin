package com.example.qrbnb_superadmin.presentation.screen

import ImagePlaceholder
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.reusable_composables.AppTopBar

import com.example.qrbnb_superadmin.presentation.reusable_composables.LoginFormSection
import com.example.qrbnb_superadmin.presentation.reusable_composables.PanelFooterText
import com.example.qrbnb_superadmin.presentation.viewmodel.LoginViewModel
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRBnBSuperadminLoginScreen(viewModel: LoginViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(title = "QRBnB Superadmin")
        },
    ) { paddingValues ->

        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ImagePlaceholder()

            Spacer(modifier = Modifier.height(8.dp))

            LoginFormSection(
                state = state,
                onEmailChanged = viewModel::onEmailChanged,
                onPasswordChanged = viewModel::onPasswordChanged,
                onLoginClicked = viewModel::login,
            )

            Spacer(modifier = Modifier.height(10.dp))

            PanelFooterText()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
