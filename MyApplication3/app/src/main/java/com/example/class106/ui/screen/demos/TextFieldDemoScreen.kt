package com.example.class106.ui.screen.demos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.class106.component.TopBarComponent
import com.example.class106.ui.theme.Class106Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextFieldDemoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarComponent(title = "TextField") {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                var input by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = input,
                    onValueChange = { input = it },
                    placeholder = { Text("Thông tin nhập") },
                    singleLine = true,
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(56.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Bạn đã nhập: ${input.ifEmpty { "..." }}",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldDemoScreenPreview() {
    Class106Theme {
        TextFieldDemoScreen(navController = rememberNavController())
    }
}