package com.example.class106.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.class106.ui.screen.HomeScreen
import com.example.class106.ui.screen.WelcomeScreen
import com.example.class106.ui.screen.demos.ColumnDemoScreen
import com.example.class106.ui.screen.demos.ImageDemoScreen
import com.example.class106.ui.screen.demos.PasswordFieldDemoScreen
import com.example.class106.ui.screen.demos.RowDemoScreen
import com.example.class106.ui.screen.demos.TextDemoScreen
import com.example.class106.ui.screen.demos.TextFieldDemoScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.WELCOME
    ) {
        composable(Route.WELCOME) {
            WelcomeScreen(navController)
        }
        composable(Route.HOME) {
            HomeScreen(navController)
        }

        composable(Route.Demo.TEXT) {
            TextDemoScreen(navController)
        }

        composable(Route.Demo.IMAGE) {
            ImageDemoScreen(navController)
        }

        composable(Route.Demo.TEXT_FIELD) {
            TextFieldDemoScreen(navController)
        }

        composable(Route.Demo.PASSWORD_FIELD) {
            PasswordFieldDemoScreen(navController)
        }

        composable(Route.Demo.COLUMN) {
            ColumnDemoScreen(navController)
        }

        composable(Route.Demo.ROW) {
            RowDemoScreen(navController)
        }
    }
}