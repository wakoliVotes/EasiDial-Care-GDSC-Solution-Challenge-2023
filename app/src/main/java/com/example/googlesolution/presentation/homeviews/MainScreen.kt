package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
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

@Composable
fun EmergencyDialog(openEmergencyDialog: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openEmergencyDialog(false)
        },
        content = {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(10.dp),
                elevation = 8.dp
            ) {
                Column(
                    Modifier
                        .background(color = Color.White)
                        .padding(16.dp)
                ) {
                    Text(text = "Attention!", fontSize = 24.sp, color = Color.Red)
                    Text(
                        text = "You are about to trigger an emergency. Do you want to proceed?",
                        fontSize = 16.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp), horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                            Text(text = "Yes", fontSize = 16.sp)
                        }
                        TextButton(
                            onClick = { openEmergencyDialog(false) },
                            modifier = Modifier.width(100.dp)
                        ) {
                            Text(text = "No", fontSize = 16.sp)
                        }
                    }
                }
            }
        },
    )
}

// TODO: Hoist top appbar states
@Composable
fun MainScreenAppBar(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
) {

    //NOTICE
    // Since the Emergency button is not directly inside the 
    // Scaffold, I moved the Emergency Dialog here so as to 
    // avoid conflicting data types. That is MutableBoolean and mutableStateOf(false)
    var openEmergencyDialog by remember { mutableStateOf(false) }
    if (openEmergencyDialog)
        Dialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openEmergencyDialog = false
            },
            content = {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.padding(10.dp),
                    elevation = 8.dp
                ) {
                    Column(
                        Modifier
                            .background(color = Color.White)
                            .padding(16.dp)
                    ) {
                        Text(text = "Attention!", fontSize = 24.sp, color = Color.Red)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "You are about to trigger an emergency. Do you want to proceed?",
                            fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp), horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = {
                                // TODO: Hoist this function; it is an "Emergency" function
                            }, modifier = Modifier.width(100.dp)) {
                                Text(text = "Yes", fontSize = 16.sp)
                            }
                            TextButton(
                                onClick = { openEmergencyDialog = false },
                                modifier = Modifier.width(100.dp)
                            ) {
                                Text(text = "No", fontSize = 16.sp)
                            }
                        }
                    }
                }
            },
        )

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
            Button(
                onClick = {
                    openEmergencyDialog = true
                },
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
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
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