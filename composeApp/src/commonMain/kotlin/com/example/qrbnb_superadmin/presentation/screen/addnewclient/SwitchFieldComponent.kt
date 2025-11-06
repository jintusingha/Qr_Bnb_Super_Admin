package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults // Import SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.ui.add_new_client_switch_description
import com.example.qrbnb_superadmin.ui.paddingTop
import com.example.qrbnb_superadmin.ui.soft_reddish
import com.example.qrbnb_superadmin.ui.sortBackground
import com.example.qrbnb_superadmin.ui.textstyle_14_size_21_lineheight
import com.example.qrbnb_superadmin.ui.textstyle_16_size_24_lineheight

@Composable
fun SwitchFieldComponent(
    field: FormField,
    value: Boolean,
    onValueChange: (Any) -> Unit,
) {
    val uncheckedTrackColor = sortBackground
    val checkedTrackColor = soft_reddish

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = field.label, style = textstyle_16_size_24_lineheight())

            if (!field.description.isNullOrEmpty()) {
                Text(
                    text = field.description,
                    style = textstyle_14_size_21_lineheight(),
                    color = add_new_client_switch_description,
                    modifier = Modifier.paddingTop(4.dp),
                )
            }
        }

        Switch(
            checked = value,
            onCheckedChange = onValueChange,
            colors =
                SwitchDefaults.colors(
                    uncheckedTrackColor = uncheckedTrackColor,
                    checkedTrackColor = checkedTrackColor,
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.Gray,
                ),
        )
    }
}
