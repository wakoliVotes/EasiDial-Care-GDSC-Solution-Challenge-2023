package com.example.googlesolution.presentation.bottomviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    object About : BottomBarScreen(
        route = "about",
        title = "About",
        icon = Icons.Default.List
    )
    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
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


@Composable
fun BottomBar(
    items: List<BottomBarScreen>,
    currentRoute: String,
    onItemSelected: (BottomBarScreen) -> Unit
) {
    BottomNavigation(
        elevation = 12.dp,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White)
    ) {
        val currentRoute = currentRoute
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = { onItemSelected(screen) },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(
        items = listOf(
            BottomBarScreen.Home,
            BottomBarScreen.About,
            BottomBarScreen.Settings,
            BottomBarScreen.Notifications,
            BottomBarScreen.Profile
        ),
        currentRoute = "home",
        onItemSelected = {}
    )
}