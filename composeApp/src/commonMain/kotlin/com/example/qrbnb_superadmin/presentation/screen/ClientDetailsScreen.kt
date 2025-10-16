package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.clientDetails.ClientDetailsContent
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.MeatBallsMenuIcon
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.leftArrowIcon


@Composable
fun ClientDetailsScreen(
    viewModel: ClientDetailsViewModel = koinInject(),
    onNavigateBack: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchClientDetails()
    }

    Scaffold(

        topBar = {

            CustomTopAppBar(

                title="Client Details",

                navigationIcon = {

                    IconButton(onClick = {}){

                        Icon(painter = painterResource(Res.drawable.leftArrowIcon),

                            contentDescription = "LeftArrow",

                            modifier = Modifier.size(24.dp))

                    }

                },

                actions = {

                    IconButton(onClick = {}){

                        Icon(

                            painter = painterResource(Res.drawable.MeatBallsMenuIcon),

                            contentDescription = "menu icon",

                            modifier = Modifier.size(24.dp)

                        )

                    }

                }

            )

        }

    ) { paddingValues ->


        if (!state.isLoading && state.error == null) {

            state.clientDetails?.let { details ->
                ClientDetailsContent(details = details, paddingValues = paddingValues)
            }
        }
    }
}
