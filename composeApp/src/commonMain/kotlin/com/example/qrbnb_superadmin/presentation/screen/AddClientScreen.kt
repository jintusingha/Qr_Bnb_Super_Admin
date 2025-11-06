package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.addnewclient.AddClientFormContent
import com.example.qrbnb_superadmin.presentation.screen.addnewclient.ErrorScreen
import com.example.qrbnb_superadmin.presentation.screen.addnewclient.LoadingScreen
import com.example.qrbnb_superadmin.presentation.screen.addnewclientformsubmission.SubmissionErrorDialog
import com.example.qrbnb_superadmin.presentation.screen.addnewclientformsubmission.SuccessDialog
import com.example.qrbnb_superadmin.presentation.state.ClientFormState
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientFormViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.leftArrowIcon

@Composable
fun AddClientScreen(
    viewModel: ClientFormViewModel = koinInject(),
    onBackClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            val title =
                when (uiState) {
                    is ClientFormState.Success -> (uiState as ClientFormState.Success).formSchema.title
                    else -> "Add New Client"
                }

            CustomTopAppBar(
                title = title,
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(Res.drawable.leftArrowIcon),
                            contentDescription = "LeftArrow",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
                actions = {},
            )
        },
    ) { paddingValues ->
        Box(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
        ) {
            when (uiState) {
                is ClientFormState.Loading -> {
                    LoadingScreen()
                }

                is ClientFormState.Success -> {
                    val formSchema = (uiState as ClientFormState.Success).formSchema
                    AddClientFormContent(
                        formSchema = formSchema,
                        onSaveClick = { formValues ->
                            viewModel.submitForm(formValues)
                        },
                        onCancelClick = onBackClick,
                    )
                }

                is ClientFormState.Error -> {
                    val message = (uiState as ClientFormState.Error).message
                    ErrorScreen(message = message, onBackClick = onBackClick)
                }
            }
        }
    }
}
