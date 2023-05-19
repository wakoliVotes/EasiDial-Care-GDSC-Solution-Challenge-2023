package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.datalayer.firebaseauth.AuthRepository
import com.example.googlesolution.datalayer.firebaseauth.login.LoginViewModel
import com.example.googlesolution.presentation.drawer_destinations.AboutUsPage
import com.example.googlesolution.presentation.drawer_destinations.EmergencyButtonPage
import com.example.googlesolution.presentation.drawer_destinations.FeedbackPage
import com.example.googlesolution.presentation.drawer_destinations.MedicalInformationPage
import com.example.googlesolution.presentation.drawer_destinations.ProfilePage
import com.example.googlesolution.presentation.homeviews.AccountView
import com.example.googlesolution.presentation.homeviews.AmbulancesView
import com.example.googlesolution.presentation.homeviews.EmergencyLessons
import com.example.googlesolution.presentation.homeviews.HomeView
import com.example.googlesolution.presentation.homeviews.HospitalsViews
import com.example.googlesolution.presentation.homeviews.MainScreen
import com.example.googlesolution.presentation.hosplocationview.HospitalsMapView
import com.example.googlesolution.presentation.onboarding.LoginScreen
import com.example.googlesolution.presentation.onboarding.OnBoardScreen
import com.example.googlesolution.presentation.onboarding.SignUpScreen


enum class LoginRoutes {
    SignIn,
    SignUp,
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = if (AuthRepository().hasUser()) Screens.MainScreen.route else Screens.OnBoarding.route
    )
    {
        composable(route = Screens.OnBoarding.route) {
            OnBoardScreen(navController = navController)
        }
        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(
                loginViewModel = loginViewModel,
                onNavToHomePage = {
                    navController.navigate(Screens.MainScreen.route) {
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignIn.name) {
                            inclusive = true
                        }
                    }
                },
                onNavToSignUpPge = {
                    navController.navigate(LoginRoutes.SignUp.name){
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignIn.name) {
                            inclusive = true
                        }
                    }
                })
        }
        composable(route = LoginRoutes.SignUp.name) {
            SignUpScreen(
                loginViewModel = loginViewModel,
                onNavToHomePage = {
                    navController.navigate(Screens.MainScreen.route) {
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignUp.name) {
                            inclusive = true
                        }
                    }
                },
                onNavToLoginpPage = {
                    navController.navigate(LoginRoutes.SignIn.name){
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignUp.name) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = Screens.MainScreen.route) {
            MainScreen(mainNavController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeView(navController = navController)
        }
        composable(route = Screens.HospitalsView.route) {
            HospitalsViews(navController = navController)
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
        composable(route = Screens.Account.route) {
            AccountView(navController = navController, loginViewModel = loginViewModel)
        }

        // Nav Drawer Destinations
        ///Start
        composable(route = Screens.ProfilePage.route) {
            ProfilePage(navController = navController)
        }
        composable(route = Screens.MedicalInformationPage.route) {
            MedicalInformationPage(navController = navController)
        }
        composable(route = Screens.EmergencyButtonPage.route) {
            EmergencyButtonPage(navController = navController)
        }
        composable(route = Screens.FeedbackPage.route) {
            FeedbackPage(navController = navController)
        }
        composable(route = Screens.AboutUsPage.route) {
            AboutUsPage(navController = navController)
        }
        ///End
    }
}
