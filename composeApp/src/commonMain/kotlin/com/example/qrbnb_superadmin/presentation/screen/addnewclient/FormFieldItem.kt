package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormField
import com.example.qrbnb_superadmin.ui.paddingBottom
import com.example.qrbnb_superadmin.ui.paddingTop
import com.example.qrbnb_superadmin.ui.style_16_24_w500

@Composable
fun FormFieldItem(
    field: FormField,
    formValues: MutableMap<String, Any>,
    onValueChange: (Any) -> Unit,
) {

    val shouldshow=field.visibleIf?.isEmpty() !=false ||
            field.visibleIf?.all {(key,value)-> formValues[key]== value }==true
    if (!shouldshow) return
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .paddingBottom(20.dp),
    ) {
        if (field.type != "switch") {
            Text(
                text = field.label,
                style = style_16_24_w500(),
                modifier = Modifier.paddingBottom(8.dp),
            )
        }

        when (field.type) {
            "text" -> {
                TextFieldComponent(
                    field = field,
                    value = formValues[field.id] as? String ?: "",
                    onValueChange = onValueChange,
                )
            }

            "email" -> {
                EmailFieldComponent(
                    field = field,
                    value = formValues[field.id] as? String ?: "",
                    onValueChange = onValueChange,
                )
            }

            "tel" -> {
                PhoneFieldComponent(
                    field = field,
                    value = formValues[field.id] as? String ?: "",
                    onValueChange = onValueChange,
                )
            }

            "select" -> {
                SelectFieldComponent(
                    field = field,
                    value = formValues[field.id] as? String ?: "",
                    onValueChange = onValueChange,
                )
            }

            "switch" -> {
                SwitchFieldComponent(
                    field = field,
                    value = formValues[field.id] as? Boolean ?: (field.defaultValue ?: false),
                    onValueChange = onValueChange,
                )
            }

            "textarea" -> {
                TextAreaFieldComponent(
                    field = field,
                    value = formValues[field.id] as? String ?: "",
                    onValueChange = onValueChange,
                )
            }
        }

//        if (field.required) {
//            Text(
//                text = "Required",
//                style = MaterialTheme.typography.labelSmall,
//                color = Color.Red,
//                modifier = Modifier.paddingTop(4.dp)
//            )
//        }
    }
}
