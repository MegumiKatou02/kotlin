package com.example.class106.ui.screen.demos

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.class106.component.TopBarComponent
import com.example.class106.ui.theme.Class106Theme
import com.example.class106.R
import androidx.core.net.toUri

@Composable
fun ImageDemoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarComponent(title = "Images") {
                navController.navigateUp()
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.peak),
                    contentDescription = "Image 1",
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))
                val context = LocalContext.current
                Text(
                    text = "https://github.com/MegumiKatou02",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, "https://github.com/MegumiKatou02".toUri())
                            context.startActivity(intent)
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.peak),
                    contentDescription = "Image 1",
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("In app")
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageDemoScreenPreview() {
    Class106Theme {
        ImageDemoScreen(navController = rememberNavController())
    }
}