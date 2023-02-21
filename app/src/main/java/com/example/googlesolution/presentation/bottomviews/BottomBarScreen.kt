package com.example.googlesolution.presentation.bottomviews

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

    object Explore : BottomBarScreen(
        route = "explore",
        title = "Explore",
        icon = Icons.Default.List
    )

    object Notifications : BottomBarScreen(
        route = "notifications",
        title = "Notifications",
        icon = Icons.Default.Notifications
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
