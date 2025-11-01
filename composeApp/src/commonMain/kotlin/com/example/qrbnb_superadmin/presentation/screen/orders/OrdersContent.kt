package com.example.qrbnb_superadmin.presentation.screen.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.qrbnb_superadmin.domain.entity.OrderListItem
import com.example.qrbnb_superadmin.domain.entity.OrderListSummary

import com.example.qrbnb_superadmin.ui.body16Regular
import com.example.qrbnb_superadmin.ui.search_field_color
import com.example.qrbnb_superadmin.ui.search_icon_placeholdertext
import kotlinx.serialization.json.JsonNull.content
import org.jetbrains.compose.resources.painterResource
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.searchicon

@Composable
fun OrdersContent(
    summary: OrderListSummary,
    orders: List<OrderListItem>,
    selectedTab:String,
    onTabSelected:(String)->Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize().padding(top = 8.dp)) {
        Column(
            modifier =
                Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.searchicon),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp),
                        tint = search_icon_placeholdertext,
                    )
                },
                placeholder = {
                    Text(
                        "Search Orders",
                        style = body16Regular(),
                        color = search_icon_placeholdertext,
                        modifier = Modifier.padding(bottom = 2.dp),
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                colors =
                    OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFF5F0F0),
                        focusedContainerColor = Color(0xFFF5F0F0),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                    ),
            )
        }

        StatusTabs(summary = summary,selectedTab=selectedTab,onTabSelected=onTabSelected)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(orders) { order ->
                OrderCard(order = order)
            }
        }
    }
}
