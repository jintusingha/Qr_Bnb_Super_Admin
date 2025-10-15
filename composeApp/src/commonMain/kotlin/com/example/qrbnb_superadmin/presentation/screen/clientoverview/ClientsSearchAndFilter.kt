package com.example.qrbnb_superadmin.presentation.screen.clientoverview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight // <-- ADDED
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.ui.body16Regular
import com.example.qrbnb_superadmin.ui.search_field_color
import com.example.qrbnb_superadmin.ui.search_icon_placeholdertext
import com.example.qrbnb_superadmin.ui.status_Color
import com.example.qrbnb_superadmin.ui.status_btn_field_color
import com.example.qrbnb_superadmin.ui.status_text_14px
import org.jetbrains.compose.resources.painterResource
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.searchicon



@Composable
fun ClientsSearchAndFilter(
    searchTerm: String,
    onSearchTermChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {

        OutlinedTextField(
            value = searchTerm,
            onValueChange = onSearchTermChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.searchicon),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp),
                    tint = search_icon_placeholdertext
                )
            },
            placeholder = {
                Text("Search clients", style = body16Regular(),
                    color = search_icon_placeholdertext,
                    modifier = Modifier.padding(bottom = 2.dp))

                          },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = search_field_color,
                focusedContainerColor = search_field_color,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
            )
        )
        Spacer(Modifier.height(20.dp))


        Button(
            onClick = { /* TODO: Open filter dialog/dropdown */ },
            modifier = Modifier
                .width(96.dp)
                .height(32.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 8.dp,
                top = 0.dp,
                bottom = 0.dp
            ),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = status_btn_field_color
            )


        ) {
            Text(
                "Status",
                style = status_text_14px(),
                color = status_Color
            )
            Spacer(Modifier.width(8.dp))
            Icon(
                Icons.Default.KeyboardArrowDown,
                tint = status_Color,

                contentDescription = "Status Filter",
                modifier = Modifier.size(18.dp)
            )
        }
    }
}