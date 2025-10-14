package com.example.class106.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.class106.navigation.Route
import com.example.class106.ui.theme.Class106Theme

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            // Tiêu đề
            Text(
                text = "UI Components List",
                color = Color(0xFF1E88E5),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Group: Display
            ComponentGroup(
                title = "Display",
                items = listOf(
                    "Text" to "Displays text",
                    "Image" to "Displays an image"
                ),
                navController = navController,
                routes = listOf(Route.Demo.TEXT, Route.Demo.IMAGE)
            )

            // Group: Input
            ComponentGroup(
                title = "Input",
                items = listOf(
                    "TextField" to "Input field for text",
                    "PasswordField" to "Input field for passwords"
                ),
                navController = navController,
                routes = listOf(Route.Demo.TEXT_FIELD, Route.Demo.PASSWORD_FIELD)
            )

            // Group: Layout
            ComponentGroup(
                title = "Layout",
                items = listOf(
                    "Column" to "Arranges elements vertically",
                    "Row" to "Arranges elements horizontally"
                ),
                navController = navController,
                routes = listOf(Route.Demo.COLUMN, Route.Demo.ROW)
            )

            // Thẻ hồng ở cuối
            ComponentCard(
                title = "Tự tìm hiểu",
                description = "Tìm ra tất cả các thành phần UI cơ bản",
                backgroundColor = Color(0xFFFFCDD2), // hồng nhạt
                textColor = Color.Black
            )
        }
    }
}

@Composable
fun ComponentGroup(
    title: String,
    items: List<Pair<String, String>>,
    navController: NavController,
    routes: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        items.forEachIndexed { index, (name, desc) ->
            ComponentCard(
                title = name,
                description = desc,
                modifier = Modifier.clickable {
                    Log.d("ComponentGroup", "Click vao $index")
                    navController.navigate(routes[index])
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ComponentCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFBBDEFB),
    textColor: Color = Color.Black
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = title,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = description,
            color = textColor.copy(alpha = 0.8f),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Class106Theme {
        HomeScreen(navController = rememberNavController())
    }
}