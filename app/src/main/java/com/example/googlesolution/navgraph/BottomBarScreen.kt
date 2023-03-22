package com.example.googlesolution.navgraph

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.googlesolution.R


// create a sealed class that has a route, title and image using painterResource
sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.home
    )
    object Hospitals : BottomBarScreen(
        route = "hospitals",
        title = "Hospitals",
        icon = R.drawable.first_aid
    )
    object Map : BottomBarScreen(
        route = "map",
        title = "Map",
        icon = R.drawable.place
    )
    object Ambulances : BottomBarScreen(
        route = "ambulances",
        title = "Ambulances",
        icon = R.drawable.car
    )
    object Learn : BottomBarScreen(
        route = "learn",
        title = "Learn",
        icon = R.drawable.library_books
    )
}

@Composable
fun painterFromResource(@DrawableRes resourceId: Int): Painter {
    return painterResource(id = resourceId)
}
