package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
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
import com.example.googlesolution.ui.theme.*

@Composable
fun HomeView(
    navController: NavHostController,
) {
    MaterialTheme {
        Scaffold(
            modifier = Modifier
                .background(BlueMildest)
                .fillMaxSize()
            ,
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(BlueMildest)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "EasiDial Care",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp)
                        .alpha(0.8f),
                    color = MaterialTheme.colors.onSecondary
                )
                Text(
                    text = "Here to help you",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp)
                        .alpha(0.5f),
                    color = MaterialTheme.colors.onSecondary
                )
                // SDG reference
                Spacer(modifier = Modifier.height(20.dp))
                // Banner - Mission + Team + Vision
                LazyRow(
                    modifier = Modifier.padding(start = 8.dp),
                ){
                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier
                                    .background(MaterialTheme.colors.primaryVariant)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Our Mission",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    color = MaterialTheme.colors.surface
                                )
                                Text(
                                    text = "To improve access to critical care services for everyone, regardless of location or economic status.",
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                    color = MaterialTheme.colors.surface
                                )
                            }
                        }
                    }
                    item{
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
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier
                                    .background(MaterialTheme.colors.onSecondary)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Our Vision",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    color = MaterialTheme.colors.surface
                                )
                                Text(
                                    text = "A world where every person has access to the healthcare services they need, when and where they need them.",
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                    color = MaterialTheme.colors.surface
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
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colors.primaryVariant)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Hospitals",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                                color = MaterialTheme.colors.surface
                            )
                            Text(
                                text = "In case of emergency, get help",
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                                color = MaterialTheme.colors.surface
                            )
                            IconButton(
                                onClick = {
                                /*TODO*/
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(lightGreen , CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "",
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
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colors.onSecondary)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Ambulances",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                                color = MaterialTheme.colors.surface
                            )
                            Text(
                                text = "Access Emergency Services",
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                                color = MaterialTheme.colors.surface
                            )
                            IconButton(
                                onClick = {
                                    /*TODO*/
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(lightGreen , CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "",
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
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colors.primaryVariant)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Learn",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                                color = MaterialTheme.colors.surface
                            )
                            Text(
                                text = "Learn about the disease",
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                                color = MaterialTheme.colors.surface
                            )
                            IconButton(
                                onClick = {
                                    /*TODO*/
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(lightGreen , CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "",
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
                        .background(MaterialTheme.colors.onPrimary),
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


