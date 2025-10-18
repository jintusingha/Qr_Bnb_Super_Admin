package com.example.qrbnb_superadmin.presentation.screen.addnewclient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.qrbnb_superadmin.domain.entity.FormSchema
import com.example.qrbnb_superadmin.ui.paddingBottom

@Composable
fun AddClientFormContent(
    formSchema: FormSchema,
    onSaveClick: (Map<String, Any>) -> Unit,
    onCancelClick: () -> Unit,
) {
    val formValues = remember { mutableStateMapOf<String, Any>() }


    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        Column(
            modifier =
                Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
        ) {
            // Display form description if it exists
//            if (formSchema.description.isNotEmpty()) {
//                Text(
//                    text = formSchema.description,
//                    style = MaterialTheme.typography.bodySmall,
//                    color = Color.Gray,
//                    modifier = Modifier.paddingBottom(16.dp)
//                )
//            }

            formSchema.fields.forEach { field ->

                FormFieldItem(
                    field = field,
                    formValues = formValues,
                    onValueChange = { value ->

                        formValues[field.id] = value
                    },
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            formSchema.actions.forEach { action ->

                FormActionButton(
                    action = action,
                    onClick = {
                        if (action.type == "submit") {
                            onSaveClick(formValues)
                        } else {
                            onCancelClick()
                        }
                    },
                )
            }
        }
    }
}
