package com.example.googlesolution.presentation.bottomviews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotificationsView(navController: NavHostController){

}





@Preview
@Composable
fun CreateNotifications(){

}



@Preview
@Composable
fun PreviewNotifications(){
    NotificationsView(navController = rememberNavController()  )

}