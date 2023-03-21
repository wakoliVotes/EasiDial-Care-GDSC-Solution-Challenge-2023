package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlesolution.datamodels.lessons
import com.example.googlesolution.presentation.bottomviews.AboutUsView
import com.example.googlesolution.presentation.bottomviews.SettingsView
import com.example.googlesolution.presentation.homeviews.AmbulancesView
import com.example.googlesolution.presentation.homeviews.EmergencyLessons
import com.example.googlesolution.presentation.homeviews.HomeDashboard
import com.example.googlesolution.presentation.locationviews.HospitalsMapView
import com.example.kcauvibe.presentation.bottomviews.AccountView


@Composable
fun BottomNavGraph(
    navController: NavHostController
    ) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeDashboard(navController = navController)
        }
        composable(route = Screens.Home.route){
            HomeDashboard(navController = navController)
        }
        composable(route = BottomBarScreen.Map.route){
            HospitalsMapView(navController = navController)
        }
        composable(route = Screens.MapView.route){
            HospitalsMapView(navController = navController)
        }
        composable(route = BottomBarScreen.Explore.route){
            EmergencyLessons(navController = navController, lessons = lessons )
        }
        composable(route = Screens.EmergencyLessons.route){
            EmergencyLessons(navController = navController, lessons = lessons )
        }
        composable(route = BottomBarScreen.Ambulances.route){
            AmbulancesView(navController = navController)
        }
        composable(route = Screens.About.route){
            AboutUsView(navController = navController)
        }
        composable(route = BottomBarScreen.Account.route){
            AccountView(navController = navController)
        }
        composable(route = Screens.Settings.route){
            SettingsView(navController = navController)
        }
    }
}