package com.example.googlesolution.presentation.bottomviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.ui.theme.WaterAccent


@Composable
fun AboutUsView(
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.background(Color.Red),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.9f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "About",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                // SDG reference
                Text(
                    text = "UN Sustainable Development Goal 3: Ensure healthy lives and promote well-being for all at all ages.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                        .alpha(0.8f)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(120.dp)
                ) {
                    Column {
                        Text(
                            text = "Our Mission",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "To improve access to critical healthcare services for everyone, regardless of their location or economic status.",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(120.dp)
                ) {
                    Column {
                        Text(
                            text = "Our Team",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "We are a team of passionate individuals who are committed to making healthcare accessible to everyone.",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )

                    }
                }
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(120.dp)
                ) {
                    Column {
                        Text(
                            text = "Our Vision",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "A world where every person has access to the healthcare services they need, when and where they need them.",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 6.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MilestoneBox(
                            milestoneName = "Years Project Started",
                            milestoneNumber = "2023",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(WaterAccent, RoundedCornerShape(4.dp))
                                .height(60.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Listed Hospitals",
                            milestoneNumber = "100+",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(WaterAccent, RoundedCornerShape(4.dp))
                                .height(60.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Listed Ambulances",
                            milestoneNumber = "20+",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(WaterAccent, RoundedCornerShape(4.dp))
                                .height(60.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Counties Covered",
                            milestoneNumber = "47",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            /* Navigate to ambulance view */
                            navController.navigate("ambulances")
                        },
                        modifier = Modifier
                            .height(45.dp)
                            .width(170.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Ambulances",
                                color = Color.White,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(horizontal = 2.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Arrow Forward",
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                    Button(
                        onClick = {
                            /* Navigate to hospitals view */
                            navController.navigate("home")
                        },
                        modifier = Modifier
                            .height(45.dp)
                            .width(170.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    ) {
                        // add arrow icon to the right of the text
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Hospitals",
                                color = Color.White,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(horizontal = 2.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Arrow Forward",
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
                // Bottom navigation bar with icons for home, about us, settings and profile
                // ADD BOTTOM NAVIGATION BAR HERE
            }
            BottomNavBarItems( navController = rememberNavController())
        }
    }
}


// card for the milestones
@Composable
fun MilestoneBox(
    milestoneName: String,
    milestoneNumber: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = milestoneNumber,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = milestoneName,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraLight,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsViewPreview() {
    AboutUsView(navController = rememberNavController())
}

@Composable
fun BottomNavBarItems(
    navController: NavHostController
) {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(bottom = 0.dp)
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Home") },
            selected = true,
            onClick = {
                      /*TODO*/
                navController.navigate("home")
                      },
            alwaysShowLabel = false,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = "Map",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Map") },
            selected = false,
            onClick = { /*TODO*/ },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Explore",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Explore") },
            selected = false,
            onClick = { /*TODO*/ },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "About",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "About") },
            selected = false,
            onClick = {
                      /*TODO*/
                        // navigate to about us
                        navController.navigate("about")
                      },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Settings") },
            selected = true,
            onClick = {
                      /*TODO*/
                      // navigate to settings
                navController.navigate("settings")
                      },
            alwaysShowLabel = false,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
        /*
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Profile") },
            selected = false,
            onClick = { /*TODO*/ },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray,
        )
         */
    }
}


