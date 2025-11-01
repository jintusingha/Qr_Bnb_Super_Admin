package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.orders.OrdersContent
import com.example.qrbnb_superadmin.presentation.state.OrdersUiState
import com.example.qrbnb_superadmin.presentation.viewmodel.OrderListViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.filter
import qr_bnb_super_admin.composeapp.generated.resources.leftArrowIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(
    clientId: String,
    onBackClick: () -> Unit,
    viewModel: OrderListViewModel = koinInject(),
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    var selectedTab by remember { mutableStateOf("All") }
    LaunchedEffect(selectedTab) {
        if (selectedTab == "All") {
            viewModel.loadOrders(clientId)
        } else {
            viewModel.loadOrders(clientId, selectedTab)
        }
    }

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Orders",
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(Res.drawable.leftArrowIcon),
                            contentDescription = "LeftArrow",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(Res.drawable.filter),
                            contentDescription = "Orders",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Box(
            modifier =
                modifier
                    .fillMaxSize()
                    .padding(paddingValues),
//                    .background(Color(0xFFF5F5F5)),
        ) {
            when (val currentState = state) {
                is OrdersUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
                is OrdersUiState.Error -> {
                    Column(
                        modifier =
                            Modifier
                                .align(Alignment.Center)
                                .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Error",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = currentState.message,
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { viewModel.loadOrders(clientId) }) {
                            Text("Retry")
                        }
                    }
                }
                is OrdersUiState.Success -> {
                    OrdersContent(
                        summary = currentState.ordersRes.summary,
                        orders = currentState.ordersRes.orders,
                        selectedTab = selectedTab,
                        onTabSelected = { selectedTab = it },
                    )
                }
            }
        }
    }
}
