package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.qrbnb_superadmin.ui.headline22Bold


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppTopBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = headline22Bold()
            )
        }
    )
}