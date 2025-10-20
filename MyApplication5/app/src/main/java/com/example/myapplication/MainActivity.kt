package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.AccountScreen
import com.example.myapplication.ui.screen.BookListScreen
import com.example.myapplication.ui.screen.ManageScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomNavigationItems = listOf(
        BottomNavigation.Manage,
        BottomNavigation.Booklist,
        BottomNavigation.Account,
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavigationItems.forEach { item ->
                    val isSelected = currentDestination?.route == item.route.route

                    NavigationBarItem(
                        selected = isSelected,
                        icon = {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.unSelectedIcon,
                                contentDescription = item.label
                            )
                        },
                        label = { Text(item.label) },
                        onClick = {
                            if (!isSelected ) {
                                navController.navigate(item.route.route) {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.startDestinationId)
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Destination.Manage.route
        ) {
            composable(Destination.Manage.route) { ManageScreen() }
            composable(Destination.BookList.route) { BookListScreen() }
            composable(Destination.Account.route) { AccountScreen() }
        }
    }
}