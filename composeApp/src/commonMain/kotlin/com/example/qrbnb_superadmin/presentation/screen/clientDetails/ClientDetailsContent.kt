package com.example.qrbnb_superadmin.presentation.screen.clientDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.ClientDetails

@Composable
fun ClientDetailsContent(details: ClientDetails, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        ClientHeader(client = details.client)

        Spacer(Modifier.height(32.dp))


        ClientInfoSection(client = details.client)

        Spacer(Modifier.height(32.dp))


        ActivityOverviewSection(overview = details.activityOverview)

        Spacer(Modifier.height(32.dp))


        TimelineSection(timelineEvents = details.timeline)


        Spacer(Modifier.height(48.dp))


        ActionButtonsSection(actions = details.actions)

        Spacer(Modifier.height(32.dp))
    }
}