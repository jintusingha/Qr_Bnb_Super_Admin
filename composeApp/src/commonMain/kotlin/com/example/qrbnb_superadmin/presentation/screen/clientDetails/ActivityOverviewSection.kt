package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.ActivityOverview
import com.example.qrbnb_superadmin.ui.activity_overview_values
import com.example.qrbnb_superadmin.ui.client_card_title
import com.example.qrbnb_superadmin.ui.headline22Bold

@Composable
fun ActivityOverviewSection(overview: ActivityOverview) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Activity Overview",
            style = headline22Bold()
        )

        Spacer(Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ActivityStatCard(
                    title = "Orders Placed",
                    value = overview.ordersPlaced.toString(),
                    modifier = Modifier.weight(1f)
                )
                ActivityStatCard(
                    title = "Items Created",
                    value = overview.itemsCreated.toString(),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ActivityStatCard(
                    title = "Categories\nCount",
                    value = overview.categoriesCount.toString(),
                    modifier = Modifier.weight(1f)
                )
                ActivityStatCard(
                    title = "Last Login",
                    value = overview.lastLogin,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun ActivityStatCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = client_card_title(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                style = activity_overview_values(),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Start
            )
        }
    }
}