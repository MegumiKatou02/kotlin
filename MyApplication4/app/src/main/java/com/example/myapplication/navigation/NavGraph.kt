package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.HomeScreen
import com.example.myapplication.ui.screen.Test
import com.example.myapplication.ui.screen.WelcomeScreen

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
        composable(Route.TEST) {
            Test(navController)
        }
    }
}