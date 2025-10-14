package com.example.class106.ui.screen.demos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.class106.component.TopBarComponent
import com.example.class106.ui.theme.Class106Theme

@Composable
    fun TextDemoScreen(navController: NavController) {
        Scaffold(
            topBar = {
                TopBarComponent(title = "Text Detail") {
                    navController.navigateUp()
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 26.sp)) {
                            append("The ")
                        }
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.LineThrough,
                                fontSize = 26.sp
                            )
                    ) {
                        append("quick")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 32.sp,
                            color = Color(0xFF8B4513)
                        )
                    ) {
                        append("Brown\n\n")
                    }
                    withStyle(style = SpanStyle(fontSize = 26.sp)) {
                        append("fox j u m p s  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    ) {
                        append("over\n\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 26.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("the")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 21.sp,
                            fontStyle = FontStyle.Italic
                        )
                    ) {
                        append("lazy")
                    }
                    withStyle(style = SpanStyle(fontSize = 26.sp)) {
                        append(" dog.")
                    }
                }
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextDemoScreenPreview() {
    Class106Theme {
        TextDemoScreen(navController = rememberNavController())
    }
}
