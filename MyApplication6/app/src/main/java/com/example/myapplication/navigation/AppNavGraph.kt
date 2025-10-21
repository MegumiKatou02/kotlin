package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.ui.screen.Home2Screen
import com.example.myapplication.ui.screen.HomeScreen
import com.example.myapplication.ui.screen.HomeScreen3
import com.example.myapplication.ui.screen.HomeScreen4
import com.example.myapplication.viewmodel.RegistrationViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val viewModel = remember { RegistrationViewModel() }

    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home.route) { HomeScreen(navController, viewModel) }
        composable(Destination.Home2.route) { Home2Screen(navController, viewModel) }
        composable(Destination.Home3.route) { HomeScreen3(navController, viewModel) }
        composable(Destination.Home4.route) { HomeScreen4(navController, viewModel) }
    }
}