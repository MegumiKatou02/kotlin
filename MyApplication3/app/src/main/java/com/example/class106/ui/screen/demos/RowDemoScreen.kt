package com.example.class106.ui.screen.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.class106.component.TopBarComponent
import com.example.class106.ui.theme.Class106Theme

@Composable
fun RowDemoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarComponent(title = "Row Layout") {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Column {
                for (i in 1..4) {
                    RowDemoComponent()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun RowDemoComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color(0xFFE6E7E8), RoundedCornerShape(12.dp))
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(60.dp).width(90.dp)
                .background(Color(0xFF90CAF9), RoundedCornerShape(12.dp))
        )
        Box(
            modifier = Modifier
                .height(60.dp).width(90.dp)
                .background(Color(0xFF1E88E5), RoundedCornerShape(12.dp)) // màu đậm hơn ở giữa
        )
        Box(
            modifier = Modifier
                .height(60.dp).width(90.dp)
                .background(Color(0xFF90CAF9), RoundedCornerShape(12.dp))
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowDemoScreenPreview() {
    Class106Theme {
        RowDemoScreen(navController = rememberNavController())
    }
}