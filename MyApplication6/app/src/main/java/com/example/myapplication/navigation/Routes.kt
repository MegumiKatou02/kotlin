package com.example.myapplication.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val route: String) {
    @Serializable
    data object Home : Destination("Home")

    @Serializable
    data object Home2 : Destination("Home2")

    @Serializable
    data object Home3 : Destination("Home3")

    @Serializable
    data object Home4 : Destination("Home4")
}

