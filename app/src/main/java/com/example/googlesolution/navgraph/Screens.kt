package com.example.googlesolution.navgraph

sealed class Screens(val route: String) {
    object SignUp: Screens("signup")
    object SignIn: Screens("signin")
    object Welcome: Screens("welcome")
    object Home: Screens("home")
    object MapView: Screens("mapview")
    object About: Screens("about")
    object Settings: Screens("settings")
    object Explore: Screens("explore")
    object Notifications: Screens("notifications")
    object Profile: Screens("profile")
}
