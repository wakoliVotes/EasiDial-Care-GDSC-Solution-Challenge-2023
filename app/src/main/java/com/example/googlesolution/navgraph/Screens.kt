package com.example.googlesolution.navgraph

sealed class Screens(val route: String) {
    object OnBoarding: Screens("onboarding")
    object SignIn : Screens("signin")
    object MainScreen : Screens("mainscreen")
    object Home : Screens("home")
    object HospitalsView : Screens("hospitalsview")
    object Ambulances : Screens("ambulances")
    object EmergencyLessons : Screens("emergencylessons")
    object MapView : Screens("mapview")
    object Settings : Screens("settings")
    object Account : Screens("account")
    object PersonsSearch : Screens("personssearch")

    object AboutUsPage : Screens("about_us_page")

    object EmergencyButtonPage : Screens("emergency_button_page")

    object FeedbackPage : Screens("feedback_page")

    object MedicalInformationPage : Screens("medical_information_page")

    object ProfilePage : Screens("profile_page")


}
