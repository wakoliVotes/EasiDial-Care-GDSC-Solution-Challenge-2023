package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.navgraph.BottomBarScreen
import com.example.googlesolution.navgraph.BottomNavGraph
import com.example.googlesolution.navgraph.painterFromResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun MainScreen(
    mainNavController: NavHostController,
) {

    val bottomNavController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MainScreenAppBar(scaffoldState, coroutineScope) },
        drawerContent = { NavDrawer(mainNavController) },
        drawerShape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerContentColor = MaterialTheme.colors.onBackground,
        bottomBar = { BottomBar(navController = bottomNavController) }) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            BottomNavGraph(navController = bottomNavController)
        }
    }
}

@Preview
@Composable
fun MainScreenPrev() {
    MainScreen(mainNavController = rememberNavController())
}

// TODO: Hoist top appbar states
@Composable
fun MainScreenAppBar(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch { scaffoldState.drawerState.open() }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.round_menu_24),
                    contentDescription = "Menu",
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.app_name), fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        actions = {
            OutlinedButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_emergency_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Emergency", fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}

@Preview
@Composable
fun MainScreenAppBarPrev() {
    MainScreenAppBar(rememberScaffoldState(), rememberCoroutineScope())
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

    BottomNavigation(
        modifier = Modifier.height(72.dp), backgroundColor = MaterialTheme.colors.background
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {

    var isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    BottomNavigationItem(
        label = {
            Text(
                text = screen.title,
                fontSize = 8.sp,
                color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
            )
        },
        icon = {
            Icon(
                painter = painterFromResource(screen.icon),
                contentDescription = screen.title,
                tint = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
                modifier = Modifier.size(if (isSelected) 36.dp else 30.dp)

            )
        },
        selected = isSelected,

        // TODO: Change the color of the selected item to green and the unselected to black
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}