package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datamodels.Ambulances
import com.example.googlesolution.datamodels.TopAmbulances
import com.example.googlesolution.datamodels.ambulances
import com.example.googlesolution.datamodels.topAmbulances
import com.example.googlesolution.presentation.bottomviews.BottomNavBarItems
import com.example.googlesolution.ui.theme.BlueMilder
import com.example.googlesolution.ui.theme.BlueMildest
import com.example.googlesolution.ui.theme.WaterMild
import com.google.accompanist.flowlayout.FlowRow

@Composable

fun AmbulancesView(
    navController: NavHostController,
) {
    Scaffold {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueMildest)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 20.dp, end = 16.dp)
                    .height(36.dp)
            ) {
                Text(
                    text = "Ambulances",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.workspaces),
                    contentDescription = "workspaces",
                )
            }
            OutlinedTextField(
                value = "",
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.DarkGray,
                    unfocusedBorderColor =  Color.LightGray,
                    focusedLabelColor =  Color.DarkGray,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.DarkGray
                ),
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(55.dp),
                label = {
                    Text(
                        text = "Find Ambulance",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),

                )
            Text(
                text = "Popular",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp, top = 4.dp, start = 16.dp)
            )
            LazyRow {
                items(topAmbulances) { topAmbulances ->
                    TopAmbulanceList(topAmbulances = topAmbulances)
                }
            }
            Text(
                text = "More",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp, start = 16.dp)
            )
            FlowRow(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(4.dp)
            ) {
                ambulances.forEach {
                    AmbulancesListItem(ambulances = it)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            BottomNavBarItems(navController = rememberNavController())
        }
    }
}

@Composable
fun AmbulancesListItem(
    ambulances: Ambulances,
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 4.dp),
        ) {
            Image(
                painter = painterResource(id = ambulances.ambImage),
                contentDescription = "",
                modifier = Modifier
                    .height(64.dp)
                    .offset(35.dp, (0).dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = ambulances.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(top = 5.dp),
            )
            Text(
                text = ambulances.contact,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(),
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 4.dp, end = 8.dp, start = 8.dp, bottom = 4.dp)
                    .fillMaxWidth()                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(15.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color.DarkGray
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.DarkGray
                    )

                }
            }
        }
    }
}

@Composable
fun TopAmbulanceList(
    topAmbulances: TopAmbulances
) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp)
            .height(144.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(topAmbulances.ambImage),
                contentDescription = "hospitals",
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .padding(0.dp)
                    .clip(CircleShape)
                ,
                contentScale = ContentScale.Crop
            )
            Text(
                text = topAmbulances.name,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                ),
                overflow = TextOverflow.Visible,
                modifier = Modifier.height(24.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top=16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(
                    onClick = {
                        /* TODO */

                    },
                    modifier = Modifier
                        .size(17.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = topAmbulances.contact,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun AmbulancePreview() {
    AmbulancesView(
        navController = rememberNavController()
    )
}



@Preview
@Composable
fun TestUIS() {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .width(176.dp)
            .clip(RoundedCornerShape(8.dp)),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.amb_stjohn),
                contentDescription = "",
                modifier = Modifier
                    .height(80.dp)
//                    .offset(-14.dp, (-8).dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "St. John Ambulance",
                fontSize = 15.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(top = 2.dp),
            )
            Text(
                text = "Thika Road, Nairobi",
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(),
                color = Color.Gray
            )
            Text(
                text = "020 55262728",
                fontSize = 15.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(),
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(15.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color.DarkGray
                    )

                }
                Text(
                    text = "020 55262728",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.DarkGray
                    )

                }
            }
        }
    }
}