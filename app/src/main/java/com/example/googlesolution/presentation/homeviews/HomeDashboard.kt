package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.presentation.onboarding.MainScreen
import com.example.googlesolution.ui.theme.WaterMilder

@Composable

fun HomeDashboard(
    navController: NavHostController
) {
    Scaffold(
    ) {
        padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            Text(
                text = "Top Hospitals",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow {
                items(5) { index ->
                    TopHospitalListItem(ambulanceName = "Aga Khan Hospital", ambulanceNumber = "02001235${index + 1}")
                }
            }
            Text(
                text = "Hospitals",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 28.dp, start = 10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(10) { index ->
                    HospitalListItem(hospitalName = "Nairobi Hospital ${index + 1}")
                }
            }
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            // Add 2 buttons to move to Home and to MapView
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                              /* Navigate to ambulance view */
                        navController.navigate("mapview")
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
                            text = "Map",
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
                              /* Navigate to map view */
                        navController.navigate("ambulances")
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
            }
            // Add card for about us and emergency lessons
            Text(
                text = "Explore",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.White),
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("emergency")
                            }
                        ,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "About Us",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .clickable {
                                    navController.navigate("about")
                                }
                        )
                        Text(
                            text = "Learn more about us",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .clickable {
                                    navController.navigate("about")
                                }
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.White),
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("emergencylessons")
                            }
                        ,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Emergency Lessons",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .clickable {
                                    navController.navigate("emergencylessons")
                                }
                        )
                        Text(
                            text = "Learn how to handle emergencies",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .clickable {
                                    navController.navigate("emergencylessons")
                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HospitalListItem(hospitalName: String) {
    Card(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .background(WaterMilder)
                .alpha(0.8f)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hospital),
                contentDescription = "Hospital",
                modifier = Modifier
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(1.5f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column (
                modifier = Modifier.weight(4f),
                    ) {
                Text(
                    text = hospitalName,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp, bottom = 4.dp)
                )
                Text(
                    text = "Address",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "Phone Number",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "Ambulance: YES/NO",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = Color.Blue
                )
            }
        }
    }
}

@Composable
fun TopHospitalListItem(
    ambulanceName: String,
    ambulanceNumber: String
) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(150.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.hosp0),
                contentDescription = "hospitals",
                modifier = Modifier.height(80.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = ambulanceName,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold,
            )
            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = ambulanceNumber,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.SemiBold,
                )
                // Add an Icon button to call the ambulance
                IconButton(
                    onClick = {
                              /* TODO */

                              },
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.Blue
                    )
                }

            }

        }
    }
}

@Preview
@Composable
fun HomeDashboardPreview() {
    HomeDashboard(navController = rememberNavController())
}