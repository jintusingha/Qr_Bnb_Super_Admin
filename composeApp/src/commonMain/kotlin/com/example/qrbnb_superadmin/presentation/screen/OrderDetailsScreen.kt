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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.qrbnb_superadmin.domain.entity.OrderDetails
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.ItemsSection
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.MetadataSection
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.OrderHeaderSection
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.OrderStatusTimeline
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.ProfileInfoRow
import com.example.qrbnb_superadmin.presentation.screen.orderDetails.TotalsSummary
import com.example.qrbnb_superadmin.presentation.viewmodel.OrderDetailsViewModel
import org.koin.compose.koinInject

@Composable
fun OrderDetailsScreen(
    viewModel: OrderDetailsViewModel = koinInject(),
    onBackClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Order Details",
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                actions = {},
            )
        },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            when {
//                uiState.isLoading -> LoadingScreen()
                // we have to make the loading screen here
//                uiState.error != null -> ErrorScreen(message = uiState.error)
                // we have to make the error screen here
                uiState.details != null -> SuccessContent(details = uiState.details!!)
            }
        }
    }
}

@Composable
fun SuccessContent(details: OrderDetails) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        // Use a vertical arrangement for consistent spacing between sections
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        // 1. Order ID and Date
        item { OrderHeaderSection(id = details.id, date = details.date) }

//        // 2. Restaurant Info
        item {
            ProfileInfoRow(
                title = details.restaurant.name,
                subtitle = details.restaurant.address,
                // Pass logoUrl or resource ID here if you had an image loader
            )
        }
//
        // 3. Customer Info
        item {
            ProfileInfoRow(
                title = details.customer.name,
                subtitle = "Phone: ${details.customer.phone}, ${details.customer.tableInfo}",

            )
        }
//
//        // Divider after main info section
        item { Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)) }
//
//        // 4. Items Section
        item { ItemsSection(items = details.items, currency = details.currency) }
//
//        // 5. Totals Summary
        item { TotalsSummary(details = details) }
//
//        // 6. Timeline Section
        item { OrderStatusTimeline(events = details.timeline) }
//
//        // 7. Metadata Section
        item { MetadataSection(metadata = details.metadata) }
//
//
    }
}
