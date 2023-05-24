package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.ui.theme.EarthDark
import com.example.googlesolution.ui.theme.GoogleSolutionTheme
import com.example.googlesolution.ui.theme.lightGreener

@Composable
fun HomeView(
    navController: NavHostController,
) {
    MaterialTheme {
        Scaffold(
            modifier = Modifier
                //.background(BlueMildest)
                .fillMaxSize(),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    //.background(BlueMildest)
                    .verticalScroll(rememberScrollState())
            ) {
                // SDG reference
                // Banner - Mission + Team + Vision
                LazyRow(
                    modifier = Modifier.padding(8.dp),
                ) {
                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    // .background(MaterialTheme.colors.primaryVariant)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Our Mission",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "To improve access to critical care services for everyone, regardless of location or economic status.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(300.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            shape = RoundedCornerShape(24.dp)

                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(0.dp)
                                    .clip(RoundedCornerShape(8.dp))

                            ) {
                                Image(
                                    contentScale = ContentScale.FillBounds,
                                    painter = painterResource(id = R.drawable.familytwo),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(8.dp))
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Our Vision",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "A world where every person has access to the healthcare services they need, when and where they need them.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(200.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            shape = RoundedCornerShape(24.dp)

                        ) {
                            Image(
                                contentScale = ContentScale.FillBounds,
                                painter = painterResource(id = R.drawable.emergency_banner),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .alpha(0.8f)
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp,
                        backgroundColor = MaterialTheme.colors.surface
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Hospitals",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "In case of emergency, get help",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("hospitalsview")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(EarthDark, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp,
                        backgroundColor = MaterialTheme.colors.secondary
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Ambulances",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "Access Emergency Services",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("ambulances")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(EarthDark, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp, top = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp, backgroundColor = MaterialTheme.colors.surface
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Learn",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "Learn about the disease",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("emergencylessons")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(EarthDark, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp)
                            .weight(0.4f)
                            .height(180.dp),
                        elevation = 4.dp,
                        shape = RoundedCornerShape(24.dp)

                    ) {
                        Image(
                            contentScale = ContentScale.FillBounds,
                            painter = painterResource(id = R.drawable.emergency_banner),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .alpha(0.8f)
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(MaterialTheme.colors.background),
                    elevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MilestoneBox(
                            milestoneName = "Year Project Started",
                            milestoneNumber = "2023",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(lightGreener, RoundedCornerShape(4.dp))
                                .height(100.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Verified Listed Hospitals",
                            milestoneNumber = "100+",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(lightGreener, RoundedCornerShape(4.dp))
                                .height(100.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Listed Ambulances",
                            milestoneNumber = "20+",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(lightGreener, RoundedCornerShape(4.dp))
                                .height(100.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Estates Covered",
                            milestoneNumber = "112",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }

                Text(
                    text = "EasiDial Care",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp)
                        .alpha(0.8f),
                )
                Text(
                    text = "Here to help you",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, bottom = 16.dp)
                        .alpha(0.5f),
                )
            }
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
    GoogleSolutionTheme(darkTheme = false) {
        HomeView(navController = rememberNavController())
    }
}


