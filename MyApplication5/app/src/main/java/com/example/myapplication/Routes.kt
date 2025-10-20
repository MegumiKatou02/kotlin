package com.example.myapplication

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val route: String) {
    @Serializable
    data object Manage : Destination("manage")

    @Serializable
    data object BookList : Destination("booklist")

    @Serializable
    data object Account : Destination("account")
}


sealed class BottomNavigation(
    val label: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: Destination
) {
    data object Manage : BottomNavigation(
        "Quản lý",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        Destination.Manage
    )

    data object Booklist : BottomNavigation(
        "DS sách",
        Icons.AutoMirrored.Filled.List,
        Icons.AutoMirrored.Outlined.List,
        Destination.BookList
    )

    data object Account : BottomNavigation(
        "Sinh viên",
        Icons.Filled.AccountCircle,
        Icons.Outlined.AccountCircle,
        Destination.Account
    )
}