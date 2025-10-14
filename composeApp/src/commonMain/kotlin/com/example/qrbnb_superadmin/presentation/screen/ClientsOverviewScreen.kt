package com.example.qrbnb_superadmin.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrbnb_superadmin.domain.entity.Client
import com.example.qrbnb_superadmin.domain.entity.ClientOverview
import com.example.qrbnb_superadmin.presentation.state.ClientsOverviewState
import com.example.qrbnb_superadmin.presentation.viewmodel.ClientsOverviewViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun ClientsOverviewScreen(
    viewModel: ClientsOverviewViewModel = koinInject()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = { ClientsTopBar() },
        floatingActionButton = { AddNewClientFAB() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            when {
                state.isLoading -> LoadingIndicator()
                state.error != null -> ErrorMessage(state.error)
                else -> ClientsContent(state)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientsTopBar() {
    TopAppBar(
        title = { Text("Clients Overview", style = MaterialTheme.typography.headlineMedium) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)

    )
}


@Composable
fun ClientsContent(state: ClientsOverviewState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {

            state.overview?.let {
                OverviewCardsRow(it)
            }
        }

        item {

            state.overview?.let {
                ActiveSubscriptionsCard(it.activeSubscriptions)
            }
        }

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "🔎 Search clients",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color.Gray
                )
            }
        }

        item {

            Row(
                modifier = Modifier
                    .background(Color.Transparent, RoundedCornerShape(4.dp))
                    .clickable { /* Handle status filter click */ }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Status", style = MaterialTheme.typography.bodyLarge)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Status Dropdown",
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(Modifier.height(8.dp))
        }


        items(state.clients) { client ->
            ClientListItem(client) {

            }
        }


        item { Spacer(Modifier.height(80.dp)) }
    }
}



@Composable
fun OverviewCardsRow(overview: ClientOverview) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OverviewCard(
                title = "Total Clients",
                value = overview.totalClients.toString(),
                modifier = Modifier.weight(1f)
            )
            OverviewCard(
                title = "Total Menus Live",
                value = overview.totalMenusLive.toString(),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun OverviewCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Text(value, fontSize = 32.sp, style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Composable
fun ActiveSubscriptionsCard(count: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Active Subscriptions", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Text(count.toString(), fontSize = 32.sp, style = MaterialTheme.typography.headlineLarge)
        }
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
fun ClientListItem(client: Client, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Client Name: ${client.name}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Client ID: ${client.id}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Details",
            tint = Color.Gray
        )
    }
}

@Composable
fun AddNewClientFAB() {
    FloatingActionButton(
        onClick = { /* Handle add client click */ },
        shape = RoundedCornerShape(50),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
            Text("Add New Client")
        }
    }
}



@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorMessage(error: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Error loading data: $error", color = MaterialTheme.colorScheme.error)
    }
}



@Preview(showBackground = true)
@Composable
private fun PreviewClientsOverviewScreen() {

    val dummyState = ClientsOverviewState(
        isLoading = false,
        overview = ClientOverview(120, 85, 102),
        clients = listOf(
            Client(id = "12345", name = "Olivia Carter"),
            Client(id = "67890", name = "Ethan Bennett"),
            Client(id = "24680", name = "Sophia Hayes"),
            Client(id = "13579", name = "Noah Parker"),
        )
    )
    Column(modifier = Modifier.padding(16.dp)) {
        ClientsContent(state = dummyState)
    }
}