package com.example.googlesolution.navgraph

sealed class Screens(val route: String) {
    object OnBoarding: Screens("onboarding")
    object SignUp: Screens("signup")
    object SignIn: Screens("signin")
    object ForgotPassword: Screens("forgotpassword")
    object MainScreen: Screens("mainscreen")
    object Home: Screens("home")
    object Ambulances: Screens("ambulances")
    object EmergencyLessons: Screens("emergencylessons")
    object MapView: Screens("mapview")
    object About: Screens("about")
    object Settings: Screens("settings")
    object Account: Screens("account")
    object Notifications: Screens("notifications")
}
