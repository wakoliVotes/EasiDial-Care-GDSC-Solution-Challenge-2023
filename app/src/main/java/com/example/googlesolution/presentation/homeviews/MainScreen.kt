package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.navgraph.BottomBarScreen
import com.example.googlesolution.navgraph.BottomNavGraph
import com.example.googlesolution.navgraph.painterFromResource
import com.example.googlesolution.ui.theme.BlueMilder


@Preview
@Composable
fun MainScreen(
) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController) }) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            BottomNavGraph(navController = navController)
        }
    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Hospitals,
        BottomBarScreen.Map,
        BottomBarScreen.Ambulances,
        BottomBarScreen.Learn,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(screen = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(
        modifier = Modifier.background(Color.White),
        label = {
            Text(
                text = screen.title,
                fontSize = 9.sp,
                color = if (
                    currentDestination?.hierarchy?.any {
                        it.route == screen.route
                    } == true
                ) BlueMilder else Color.Black
            )
        },
icon = {
       Icon(
           painter = painterFromResource(screen.icon ),
           contentDescription = screen.title,
           tint = if (
               currentDestination?.hierarchy?.any {
                   it.route == screen.route
               } == true
           ) BlueMilder else Color.Black,
       )
},
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        // TODO: Change the color of the selected item to green and the unselected to black
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}