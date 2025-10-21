package com.example.myapplication.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.navigation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backButton: Boolean,
    navController: NavController,
    firstText: String,
    secondText: String,
    textButton: String,
    buttonOnclick: () -> Unit,
    thirdComposable: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (backButton) {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                )
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Image(
                painter = painterResource(id = R.drawable.jetpackcompose),
                contentDescription = "App logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "SmartTasks",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = firstText,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = secondText,
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(25.dp))

            thirdComposable()

            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = buttonOnclick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(textButton)
            }
        }
    }
}