package com.example.myapplication.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.component.MainScreen
import com.example.myapplication.navigation.Destination
import com.example.myapplication.viewmodel.RegistrationViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RegistrationViewModel
) {
    var emailInput by remember { mutableStateOf("") }
    MainScreen(
        navController = navController,
        backButton = false,
        firstText = "Forget Password?",
        secondText = "Enter your email, we will send you a verification\ncode.",
        textButton = "Next",
        buttonOnclick = {
            viewModel.email.value = emailInput
            navController.navigate(Destination.Home2.route)
        }
    ) {
        OutlinedTextField(
            value =  emailInput,
            onValueChange = { emailInput = it },
            modifier = Modifier
                .fillMaxWidth(),

            placeholder = { Text("Your Email") },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email Icon"
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

        Spacer(modifier = Modifier.height(20.dp))
        if (viewModel.email.value.isNotEmpty() && viewModel.password.value.isNotEmpty()) {
            Log.d("test", viewModel.email.value + " " + viewModel.password.value)
            Text(
                text = "Email: ${viewModel.email.value}",
                color = Color.Red,
                fontSize = 20.sp
            )
            Text(
                text = "Password: ${viewModel.password.value}",
                color = Color.Red,
                fontSize = 20.sp
            )
        } else {
            Log.d("test", "null roi")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen(
            navController = rememberNavController(),
            viewModel = RegistrationViewModel()
        )
    }
}