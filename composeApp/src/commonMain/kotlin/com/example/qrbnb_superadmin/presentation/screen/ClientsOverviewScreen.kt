package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.clientoverview.ClientListItem
import com.example.qrbnb_superadmin.presentation.screen.clientoverview.ClientsSearchAndFilter
import com.example.qrbnb_superadmin.presentation.screen.clientoverview.ClientsStatsSection
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientsOverviewViewModel
import com.example.qrbnb_superadmin.ui.add_new_client_floating_btn_text
import com.example.qrbnb_superadmin.ui.floating_add_icon_color
import com.example.qrbnb_superadmin.ui.floating_add_new_client_background_color
import com.example.qrbnb_superadmin.ui.floating_add_new_client_text_color
import com.example.qrbnb_superadmin.ui.headline22Bold
import com.example.qrbnb_superadmin.ui.white_color
import com.example.qrbnb_superadmin.ui.white_text_color
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.addicon
import qr_bnb_super_admin.composeapp.generated.resources.hamburger
import qr_bnb_super_admin.composeapp.generated.resources.profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientsOverviewScreen(
    viewModel: ClientsOverviewViewModel = koinInject(),
    onClientClick: (clientId: String) -> Unit,
    onAddClientClick: () -> Unit,
    onTotalClientsClick:()->Unit
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "QRBnB",
                navigationIcon = {
                    IconButton(onClick = { /* Handle Menu Click */ }) {
                        Icon(
                            painter = painterResource(Res.drawable.hamburger),
                            contentDescription = "Menu",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle Profile Click */ }) {
                        Icon(
                            painter = painterResource(Res.drawable.profile),
                            contentDescription = "Profile",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddClientClick,
                modifier =
                    Modifier
                        .width(201.dp)
                        .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                containerColor = floating_add_new_client_background_color,
                contentColor = Color.White,
                icon = {
                    Icon(
                        painter = painterResource(Res.drawable.addicon),
                        contentDescription = "Add New Client",
                        modifier = Modifier.size(24.dp),
                        tint = white_color,
                    )
                },
                text = {
                    Text(
                        "Add New Client",
                        style = add_new_client_floating_btn_text(),
                        color = white_text_color,
                    )
                },
            )
        },
    ) { paddingValues ->

        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues),
        ) {
            Text(
                text = "Clients Overview",
                style = headline22Bold(),
                modifier = Modifier.padding(16.dp),
            )
            Spacer(Modifier.height(8.dp))

            ClientsStatsSection(overview = state.overview,onTotalClientsClick=onTotalClientsClick)
            Spacer(Modifier.height(16.dp))

            ClientsSearchAndFilter(
                searchTerm = state.searchTerm,
                onSearchTermChange = viewModel::onSearchTermChange,
            )
            Spacer(Modifier.height(8.dp))

            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxWidth()


                        .weight(1f)
                .background(Color.White),
                contentPadding = PaddingValues(bottom = 80.dp),
            ) {
                if (state.isLoading) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }

                items(state.filteredClients) { client ->
                    ClientListItem(client = client, onClick = onClientClick)
                }
            }
        }
    }
}
