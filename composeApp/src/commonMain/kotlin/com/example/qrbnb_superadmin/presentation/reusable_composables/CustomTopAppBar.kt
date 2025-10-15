package com.example.qrbnb_superadmin.presentation.reusable_composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

import com.example.qrbnb_superadmin.ui.top_Bar_middleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,


    navigationIcon: @Composable (() -> Unit)? = null,


    actions: @Composable (() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        title = {

            Text(
                text = title,
                style = top_Bar_middleText()

            )
        },

        navigationIcon = { navigationIcon?.invoke() },
        actions = { actions?.invoke() }
    )
}