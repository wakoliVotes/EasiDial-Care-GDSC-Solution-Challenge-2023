package com.example.googlesolution.navgraph

sealed class Screens(val route: String) {
    object OnBoarding: Screens("onboarding")
    object SignIn: Screens("signin")
    object MainScreen: Screens("mainscreen")
    object Home: Screens("home")
    object HospitalsView: Screens("hospitalsview")
    object Ambulances: Screens("ambulances")
    object EmergencyLessons: Screens("emergencylessons")
    object MapView: Screens("mapview")
    object Settings: Screens("settings")
    object Account: Screens("account")
}
