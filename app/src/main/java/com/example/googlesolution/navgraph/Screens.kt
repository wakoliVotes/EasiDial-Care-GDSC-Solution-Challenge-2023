package com.example.googlesolution.navgraph

sealed class Screens(val route: String) {
    object OnBoarding: Screens("onboarding")
    object SignUp: Screens("signup")
    object SignIn: Screens("signin")
    object Home: Screens("home")
    object Ambulances: Screens("ambulances")
    object EmergencyLessons: Screens("emergencylessons")
    object MapView: Screens("mapview")
    object About: Screens("about")
    object Account: Screens("account")
    object Settings: Screens("settings")
    object Notifications: Screens("notifications")
    object Profile: Screens("profile")
}
