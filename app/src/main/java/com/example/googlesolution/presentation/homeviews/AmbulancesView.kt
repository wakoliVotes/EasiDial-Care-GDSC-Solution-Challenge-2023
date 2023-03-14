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
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 40.dp, end = 8.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "HEALTH CHECK",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Image(painter = painterResource(id = R.drawable.workspaces),
                    contentDescription = "workspaces"
                )
            }
            Text(
                text = "Top Ambulances",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp, top = 16.dp, start = 10.dp)
            )
            LazyRow {
                items(topAmbulances) { topAmbulances ->
                    TopAmbulanceList(topAmbulances = topAmbulances)
                }
            }
            Text(
                text = "Ambulances",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(55.dp)
                ,
                label = {
                    Text(
                        text = "Search",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    )
                },
                trailingIcon = {
                    Icons.Default.Search
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),

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
            .height(144.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.LightGray),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(ambulances.ambImage),
            contentDescription = "Hospital",
            modifier = Modifier
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium),
            verticalAlignment = Alignment.Bottom,
        ) {

            Column (
                modifier = Modifier
                    .weight(0.7f)
                    .background(Color.Black.copy(alpha = 0.6f)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ambulances.name,
                    modifier = Modifier
                        .padding(start = 4.dp, end = 4.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ),
                    overflow = TextOverflow.Visible,
                )
                Row(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(15.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Call",
                            tint = Color.Blue
                        )
                    }
                    Text(
                        text = ambulances.contact,
                        style = TextStyle(
                            fontWeight = FontWeight.Light,
                            fontSize = 13.sp,
                            color = Color.White
                        )
                    )
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(15.dp)
                            .rotate(-40f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Share",
                            tint = Color.Blue
                        )
                    }
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
            .padding(start = 12.dp)
            .height(144.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(4.dp)),
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
                        .size(15.dp)
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