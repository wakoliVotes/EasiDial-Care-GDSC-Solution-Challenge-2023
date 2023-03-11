package com.example.googlesolution.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlesolution.datamodels.lessons
import com.example.googlesolution.presentation.bottomviews.AboutUsView
import com.example.googlesolution.presentation.bottomviews.SettingsView
import com.example.googlesolution.presentation.homeviews.EmergencyLessons
import com.example.googlesolution.presentation.homeviews.HomeDashboard
import com.example.googlesolution.presentation.locationviews.HospitalsMapView
import com.example.kcauvibe.presentation.bottomviews.AccountView

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
    object Explore : BottomBarScreen(
        route = "explore",
        title = "Explore",
        icon = Icons.Default.List
    )
    object About : BottomBarScreen(
        route = "about",
        title = "About",
        icon = Icons.Default.Info
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
        composable(route = BottomBarScreen.Map.route){
            HospitalsMapView(navController = navController)
        }
        composable(route = BottomBarScreen.Explore.route){
            EmergencyLessons(navController = navController, lessons = lessons )
        }
        composable(route = BottomBarScreen.About.route){
            AboutUsView(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingsView(navController = navController)
        }
    }
}