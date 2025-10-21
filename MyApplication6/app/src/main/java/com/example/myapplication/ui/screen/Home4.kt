package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
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
import com.example.myapplication.component.OutlinedTextFieldScreen
import com.example.myapplication.navigation.Destination
import com.example.myapplication.viewmodel.RegistrationViewModel

@Composable
fun HomeScreen4(navController: NavController, viewModel: RegistrationViewModel) {
    MainScreen(
        navController = navController,
        backButton = false,
        firstText = "Confirm",
        secondText = "We are here to help you!",
        textButton = "Submit",
        buttonOnclick = {
            navController.navigate(Destination.Home.route)
        }
    ) {
        OutlinedTextFieldScreen(
            value = viewModel.email.value,
            readOnly = true,
            placeholderText = "Email",
            iconField = Icons.Filled.Email
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextFieldScreen(
            value = viewModel.password.value,
            readOnly = true,
            placeholderText = "Password",
            iconField = Icons.Filled.Lock
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen4Preview() {
    MyApplicationTheme {
        HomeScreen4(
            navController = rememberNavController(),
            viewModel = RegistrationViewModel()
        )
    }
}