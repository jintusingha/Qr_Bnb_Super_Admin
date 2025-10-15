package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientDetailsViewModel
import org.koin.compose.koinInject

@Composable
fun ClientDetailsScreen(
    viewModel: ClientDetailsViewModel = koinInject()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchClientDetails()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.clientDetails != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Client Info
                    Text("Client Info:", style = MaterialTheme.typography.titleLarge)
                    Text("Name: ${state.clientDetails!!.client.name}")
                    Text("Email: ${state.clientDetails!!.client.email}")
                    Text("Phone: ${state.clientDetails!!.client.phone}")
                    Text("Status: ${state.clientDetails!!.client.subscriptionStatus}")
                    Text("Registered: ${state.clientDetails!!.client.registrationDate}")

                    Spacer(modifier = Modifier.height(16.dp))

                    // Activity Overview
                    Text("Activity Overview:", style = MaterialTheme.typography.titleLarge)
                    Text("Orders: ${state.clientDetails!!.activityOverview.ordersPlaced}")
                    Text("Items: ${state.clientDetails!!.activityOverview.itemsCreated}")
                    Text("Categories: ${state.clientDetails!!.activityOverview.categoriesCount}")
                    Text("Last Login: ${state.clientDetails!!.activityOverview.lastLogin}")

                    Spacer(modifier = Modifier.height(16.dp))

                    // Timeline
                    if (state.clientDetails!!.timeline.isNotEmpty()) {
                        Text("Timeline:", style = MaterialTheme.typography.titleLarge)
                        state.clientDetails!!.timeline.forEach { event ->
                            Text("• ${event.title} (${event.date})")
                            Text("  ${event.description}")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Actions
                    if (state.clientDetails!!.actions.isNotEmpty()) {
                        Text("Actions:", style = MaterialTheme.typography.titleLarge)
                        state.clientDetails!!.actions.forEach { action ->
                            Button(
                                onClick = { },
                                enabled = action.enabled,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Text(action.label)
                            }
                        }
                    }
                }
            }
            else -> {
                Text("No data", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}