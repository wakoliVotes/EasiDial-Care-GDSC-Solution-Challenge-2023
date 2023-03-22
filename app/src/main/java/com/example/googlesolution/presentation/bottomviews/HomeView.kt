package com.example.googlesolution.presentation.bottomviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
fun HomeView(
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.background(Color.Red),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.9f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "EasierHelp",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    color = Color.Black
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
                            milestoneName = "Estates Covered",
                            milestoneNumber = "112",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
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
    HomeView(navController = rememberNavController())
}


