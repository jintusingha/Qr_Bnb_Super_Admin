package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.qrbnb_superadmin.domain.entity.Order
import com.example.qrbnb_superadmin.domain.entity.OrderStatusSummary
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.orders.OrdersContent
import com.example.qrbnb_superadmin.presentation.state.OrdersUiState
import com.example.qrbnb_superadmin.presentation.viewmodel.OrdersViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.filter
import qr_bnb_super_admin.composeapp.generated.resources.profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(
    viewModel: OrdersViewModel = koinInject(),
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Orders",
                navigationIcon = {},
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
                        Button(onClick = { viewModel.loadOrders() }) {
                            Text("Retry")
                        }
                    }
                }
                is OrdersUiState.Success -> {
                    OrdersContent(
                        statusSummary = currentState.ordersRes.statusSummary,
                        orders = currentState.ordersRes.orders,
                    )
                }
            }
        }
    }
}
