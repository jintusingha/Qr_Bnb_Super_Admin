import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qrbnb_superadmin.presentation.reusable_composables.CustomTopAppBar
import com.example.qrbnb_superadmin.presentation.screen.ordersOverview.DashboardContent
import com.example.qrbnb_superadmin.presentation.screen.ordersOverview.OrderStatsSection
import com.example.qrbnb_superadmin.presentation.state.OrdersOverviewState
import com.example.qrbnb_superadmin.presentation.viewmodel.OrdersOverviewViewModel
import com.example.qrbnb_superadmin.ui.style_18_23_w700
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.leftArrowIcon

@Composable
fun OrdersOverviewScreen(
    viewModel: OrdersOverviewViewModel = koinInject(),
    onBackClick: () -> Unit,
    onClientClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CustomTopAppBar(
                title = "Orders Overview",
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(Res.drawable.leftArrowIcon),
                            contentDescription = "LeftArrow",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle add order action */ },
                containerColor = Color(0xFFFF5252),
                contentColor = Color.White,
                shape = RoundedCornerShape(28.dp),
                modifier =
                    Modifier
                        .width(64.dp)
                        .height(56.dp),
            ) {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp, end = 24.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Order",
                        modifier = Modifier.size(24.dp),
                    )
                }
            }
        },
    ) { paddingValues ->
        when (state) {
            is OrdersOverviewState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(48.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Loading Dashboard Data...")
                    }
                }
            }

            is OrdersOverviewState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Error: ${(state as OrdersOverviewState.Error).message}",
                        color = Color.Red,
                    )
                }
            }

            is OrdersOverviewState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(scrollState)
                ) {
                    Text(
                        text = "Key Metrics",
                        style = style_18_23_w700(),
                        modifier = Modifier.padding(16.dp),
                    )
                    Spacer(Modifier.height(8.dp))

                    val data = (state as OrdersOverviewState.Success).data.data
                    DashboardContent(data, onClientClick = onClientClick)
                }
            }
        }
    }
}