package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.component.MainScreen
import com.example.myapplication.navigation.Destination
import com.example.myapplication.viewmodel.RegistrationViewModel

@Composable
fun HomeScreen3(navController: NavController, viewModel: RegistrationViewModel) {
    MainScreen(
        navController = navController,
        backButton = false,
        firstText = "Create new password",
        secondText = "Your new password must be different from previously used password",
        textButton = "Next",
        buttonOnclick = {
            navController.navigate(Destination.Home4.route)
        }
    ) {
        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            modifier = Modifier
                .fillMaxWidth(),

            placeholder = { Text("Password") },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Lock Icon"
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
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            modifier = Modifier
                .fillMaxWidth(),

            placeholder = { Text("Confirm Password") },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Lock Icon"
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen3Preview() {
    MyApplicationTheme {
        HomeScreen3(
            navController = rememberNavController(),
            viewModel = RegistrationViewModel()
        )
    }
}