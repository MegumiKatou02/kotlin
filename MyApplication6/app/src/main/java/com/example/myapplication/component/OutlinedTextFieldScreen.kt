package com.example.myapplication.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldScreen(
    value: String,
    readOnly: Boolean,
    placeholderText: String,
    iconField: ImageVector,
    contentDescriptionText: String = "text"
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = readOnly,
        modifier = Modifier
            .fillMaxWidth(),

        placeholder = { Text(placeholderText) },

        leadingIcon = {
            Icon(
                imageVector = iconField,
                contentDescription = contentDescriptionText
            )
        },


        shape = RoundedCornerShape(16.dp),

        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF9F9F9),
            focusedContainerColor = Color(0xFFF9F9F9),

            unfocusedBorderColor = Color(0xFFE0E0E0),
            focusedBorderColor = Color.Gray,

            unfocusedLeadingIconColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
        )
    )
}