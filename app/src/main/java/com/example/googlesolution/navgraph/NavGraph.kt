package com.example.googlesolution.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.datamodels.firebaseauth.login.LoginScreen
import com.example.googlesolution.datamodels.firebaseauth.login.LoginViewModel
import com.example.googlesolution.datamodels.firebaseauth.login.SignUpScreen
import com.example.googlesolution.presentation.bottomviews.HomeView
import com.example.googlesolution.presentation.homeviews.*
import com.example.googlesolution.presentation.locationviews.HospitalsMapView
import com.example.googlesolution.presentation.onboarding.OnBoardScreen
import com.example.kcauvibe.presentation.bottomviews.AccountView


enum class LoginRoutes {
    SignIn,
    SignUp,
    LogOut
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.OnBoarding.route) {
        composable(route = Screens.OnBoarding.route) {
            OnBoardScreen(navController = navController)
        }
        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(onNavToHomePage = {
                /*TODO*/
                navController.navigate(Screens.MainScreen.route) {
                    launchSingleTop = true
                    popUpTo(route = Screens.SignIn.route) {
                        inclusive = true
                    }

                }
            },
                loginViewModel = loginViewModel

            ) {
                navController.navigate(LoginRoutes.SignUp.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {

                        inclusive = true
                    }
                }

            }
        }
        composable(route = LoginRoutes.SignUp.name) {
            SignUpScreen(onNavToHomePage = {
                /*TODO*/
                navController.navigate(Screens.MainScreen.route) {
                    launchSingleTop = true
                    popUpTo(route = Screens.SignIn.route) {
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)
            }
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
