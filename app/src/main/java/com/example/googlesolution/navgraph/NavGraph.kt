package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.presentation.bottomviews.AboutUsView
import com.example.googlesolution.presentation.bottomviews.NotificationsView
import com.example.googlesolution.presentation.bottomviews.SettingsView
import com.example.googlesolution.presentation.homeviews.AmbulancesView
import com.example.googlesolution.presentation.homeviews.EmergencyLessons
import com.example.googlesolution.presentation.homeviews.HomeDashboard
import com.example.googlesolution.presentation.locationviews.HospitalsMapView
import com.example.googlesolution.presentation.onboarding.ForgotPasswordView
import com.example.googlesolution.presentation.onboarding.OnBoardScreen
import com.example.googlesolution.presentation.onboarding.SignInView
import com.example.googlesolution.presentation.onboarding.SignUpView
import com.example.kcauvibe.presentation.bottomviews.AccountView


@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.OnBoarding.route) {
        composable(route = Screens.OnBoarding.route) {
            OnBoardScreen(navController = navController)
        }
        composable(route = Screens.SignUp.route) {
            SignUpView(navController = navController)
        }
        composable(route = Screens.SignIn.route) {
            SignInView(navController = navController)
        }
        composable(route = Screens.ForgotPassword.route) {
            ForgotPasswordView(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeDashboard(navController = navController)
        }
        composable(route = Screens.Ambulances.route) {
            AmbulancesView(navController = navController)
        }
        composable(route = Screens.EmergencyLessons.route) {
            EmergencyLessons(navController = navController)
        }
        composable(route = Screens.MapView.route) {
            HospitalsMapView(navController = navController)
        }
        composable(route = Screens.About.route) {
            AboutUsView(navController = navController)
        }
        composable(route = Screens.Account.route) {
            AccountView(navController = navController)
        }
        composable(route = Screens.Settings.route) {
            SettingsView(navController = navController)
        }
        composable(route = Screens.Notifications.route) {
            NotificationsView(navController = navController)
        }
    }
}
