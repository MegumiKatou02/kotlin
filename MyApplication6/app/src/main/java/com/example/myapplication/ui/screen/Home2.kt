package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.R
import com.example.myapplication.component.MainScreen
import com.example.myapplication.navigation.Destination
import com.example.myapplication.viewmodel.RegistrationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home2Screen(navController: NavController, viewModel: RegistrationViewModel) {
    var otpValue by remember { mutableStateOf("") }
    val otpLength = 5

    MainScreen(
        navController = navController,
        backButton = true,
        firstText = "Verify Code",
        secondText = "Enter the code\nwe just send you on your register Email.",
        textButton = "Next",
        buttonOnclick = {
            navController.navigate(Destination.Home3.route)
        }
    ) {
        BasicTextField(
            value = otpValue,
            onValueChange = {
                if (it.length <= otpLength && it.all { c -> c.isDigit() }) {
                    otpValue = it
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            decorationBox = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    repeat(otpLength) { index ->
                        OtpCell(
                            char = otpValue.getOrNull(index),
                            isFocused = otpValue.length == index
                        )
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen2Preview() {
    MyApplicationTheme {
        Home2Screen(navController = rememberNavController(), viewModel = RegistrationViewModel())
    }
}

@Composable
fun OtpCell(
    char: Char?,
    isFocused: Boolean
) {
    val shape = RoundedCornerShape(8.dp)
    val borderColor = if (isFocused) MaterialTheme.colorScheme.primary else Color(0xFFE0E0E0)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp)
            .background(Color(0xFFF9F9F9), shape)
            .border(
                border = BorderStroke(1.dp, borderColor),
                shape = shape
            )
    ) {
        if (char != null) {
            Text(
                text = char.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}