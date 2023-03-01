package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.presentation.bottomviews.BottomNavBarItems
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
        ) {
            Text(
                text = "Top Hospitals",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp, top = 16.dp, start = 10.dp)
            )
            LazyRow {
                items(5) { index ->
                    TopHospitalListItem(ambulanceName = "Aga Khan Hospital", ambulanceNumber = "02001235${index + 1}")
                }
            }
            Text(
                text = "Hospitals",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp, start = 16.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                items(10) { index ->
                    HospitalListItem(hospitalName = "Nairobi Hospital ${index + 1}")
                }
            }
            Divider(modifier = Modifier
                .padding(vertical = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                ,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                              /* Navigate to ambulance view */
                        navController.navigate("emergencylessons")
                              },
                    modifier = Modifier
                        .height(30.dp)
                        .width(120.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Learn",
                            color = Color.White,
                            fontSize = 9.sp,
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Arrow Forward",
                            tint = Color.White,
                            modifier = Modifier
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
                        .height(30.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                ) {
                    // add arrow icon to the right of the text
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ambulances",
                            color = Color.White,
                            fontSize = 9.sp,
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
            BottomNavBarItems(navController = rememberNavController())
        }
    }
}

@Composable
fun HospitalListItem(hospitalName: String) {
    Card(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(Color.LightGray)
        ,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .alpha(0.8f)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hospital),
                contentDescription = "Hospital",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(64.dp)
                    .clip(MaterialTheme.shapes.small)
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column (
                modifier = Modifier.weight(4f),
                    ) {
                Text(
                    text = hospitalName,
                    modifier = Modifier.padding(top = 5.dp, bottom = 4.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                )
                Text(
                    text = "1026 Road, City, State",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    text = "020 06252617",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp
                    )
                )
                Text(
                    text = "Has Ambulance: Yes",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp
                    )
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 5.dp, bottom = 5.dp)
                    .height(60.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .size(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Call",
                        tint = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .size(16.dp)
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

@Composable
fun TopHospitalListItem(
    ambulanceName: String,
    ambulanceNumber: String
) {
    Card(
        modifier = Modifier
            .padding(start = 5.dp)
            .height(100.dp)
            .width(120.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.hosp0),
                contentDescription = "hospitals",
                modifier = Modifier
                    .height(55.dp)
                    .width(70.dp)
                    .padding(top = 5.dp, bottom = 2.dp)
                ,
                contentScale = ContentScale.Crop
            )
            Text(
                text = ambulanceName,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                ),
            )
            Row(
                modifier = Modifier.padding(top = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
           ) {
                Text(
                    text = ambulanceNumber,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                    ),
                )
                // Add an Icon button to call the ambulance
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(
                    onClick = {
                              /* TODO */

                              },
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .size(12.dp)
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