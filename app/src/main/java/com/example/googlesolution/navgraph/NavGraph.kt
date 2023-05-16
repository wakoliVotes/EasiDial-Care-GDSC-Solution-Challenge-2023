package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.presentation.onboarding.LoginScreen
import com.example.googlesolution.datalayer.firebaseauth.login.LoginViewModel
import com.example.googlesolution.presentation.onboarding.SignUpScreen
import com.example.googlesolution.presentation.homeviews.HomeView
import com.example.googlesolution.presentation.homeviews.*
import com.example.googlesolution.presentation.hosplocationview.HospitalsMapView
import com.example.googlesolution.presentation.onboarding.OnBoardScreen
import com.example.googlesolution.presentation.homeviews.AccountView


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
        startDestination = Screens.OnBoarding.route
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
            MainScreen()
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
    }
}
