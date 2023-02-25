package com.example.googlesolution.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlesolution.presentation.bottomviews.AboutUsView
import com.example.googlesolution.presentation.bottomviews.SettingsView
import com.example.googlesolution.presentation.homeviews.HomeDashboard
import com.example.kcauvibe.presentation.bottomviews.AccountView

/* import androidx.navigation.NavHostController */


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
    object About : BottomBarScreen(
        route = "about",
        title = "About",
        icon = Icons.Default.Info
    )
    object Notifications : BottomBarScreen(
        route = "notifications",
        title = "Notifications",
        icon = Icons.Default.Home
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        Icons.Default.Settings
    )
}

@Composable
fun BottomNavGraph(
    navController: NavHostController
    ) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeDashboard(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingsView(navController = navController)
        }
        composable(route = BottomBarScreen.About.route){
            AboutUsView(navController = navController)
        }

        composable(route = BottomBarScreen.Profile.route){
            AccountView(navController = navController)
        }
    }
}