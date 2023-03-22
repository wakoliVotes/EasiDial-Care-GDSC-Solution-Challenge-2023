package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlesolution.datamodels.lessons
import com.example.googlesolution.presentation.bottomviews.HomeView
import com.example.googlesolution.presentation.homeviews.AmbulancesView
import com.example.googlesolution.presentation.homeviews.EmergencyLessons
import com.example.googlesolution.presentation.homeviews.HospitalsViews
import com.example.googlesolution.presentation.locationviews.HospitalsMapView


@Composable
fun BottomNavGraph(
    navController: NavHostController
    ) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeView(navController = navController)
        }
        composable(route = Screens.Home.route){
            HomeView(navController = navController)
        }
        composable(route = BottomBarScreen.Hospitals.route){
            HospitalsViews(navController = navController)
        }
        composable(route = BottomBarScreen.Map.route){
            HospitalsMapView(navController = navController)
        }
        composable(route = Screens.MapView.route){
            HospitalsMapView(navController = navController)
        }
        composable(route = BottomBarScreen.Learn.route){
            EmergencyLessons(navController = navController, lessons = lessons )
        }
        composable(route = Screens.EmergencyLessons.route){
            EmergencyLessons(navController = navController, lessons = lessons )
        }
        composable(route = BottomBarScreen.Ambulances.route){
            AmbulancesView(navController = navController)
        }
    }
}