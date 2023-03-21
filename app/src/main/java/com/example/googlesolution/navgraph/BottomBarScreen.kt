package com.example.googlesolution.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Map : BottomBarScreen(
        route = "map",
        title = "Map",
        icon = Icons.Default.Place
    )
    object Ambulances : BottomBarScreen(
        route = "ambulances",
        title = "Ambulances",
        Icons.Default.Settings
    )
    object Explore : BottomBarScreen(
        route = "explore",
        title = "Learn",
        icon = Icons.Default.List
    )
    object Account : BottomBarScreen(
        route = "account",
        title = "Account",
        icon = Icons.Default.Person
    )
}
